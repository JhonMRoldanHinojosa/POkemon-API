package org.example.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.example.tasks.GetPokemon;
import org.example.tasks.PostPokemon;
import org.example.tasks.PutPokemon;
import org.example.tasks.DeletePokemon;
import org.example.question.ResponseCode;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PokemonStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());  // Configura el escenario para los actores
    }

    @Given("el {actor} establece el endpoint GET para obtener los Pokémon")
    public void establecerEndpointGET(Actor actor) {
        actor.whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
    }

    @When("el {actor} envía una solicitud HTTP GET")
    public void enviarSolicitudGET(Actor actor) {
        actor.attemptsTo(GetPokemon.fromEndpoint("/pokemon"));
    }

    @Then("el código de respuesta HTTP debería ser {int}")
    public void verificarCodigoRespuesta(int responseCode) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus(), equalTo(responseCode)));
    }

    @Given("el {actor} establece el endpoint POST para crear un Pokémon")
    public void establecerEndpointPOST(Actor actor) {
        actor.whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
    }

    @When("el {actor} envía una solicitud HTTP POST con {string} {string}")
    public void enviarSolicitudPOST(Actor actor, String name, String url) {

        actor.attemptsTo(PostPokemon.withDetails(name, url));
    }


    @Given("el {actor} establece el endpoint PUT para actualizar un Pokémon")
    public void establecerEndpointPUT(Actor actor) {
        actor.whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
    }

    @When("el {actor} envía una solicitud HTTP PUT con {string} {string} {string}")
    public void enviarSolicitudPUT(Actor actor, String id, String name, String url) {
        // Ahora tienes 4 parámetros: actor, id, name y url
        actor.attemptsTo(PutPokemon.withDetails(id, name, url));
    }


    @Given("el {actor} establece el endpoint DELETE para eliminar un Pokémon")
    public void establecerEndpointDELETE(Actor actor) {
        actor.whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
    }

    @When("el {actor} envía una solicitud HTTP DELETE con {string}")
    public void enviarSolicitudDELETE(Actor actor, String id) {
        // Ahora tienes dos parámetros: actor y id
        actor.attemptsTo(DeletePokemon.withId(id));
    }

}

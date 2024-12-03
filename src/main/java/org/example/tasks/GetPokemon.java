package org.example.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPokemon implements Task {
    private final String endpoint;

    public GetPokemon(String endpoint) {
        this.endpoint = endpoint;
    }

    public static Performable fromEndpoint(String endpoint) {
        return instrumented(GetPokemon.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint)
                .with(request -> request.contentType(ContentType.JSON)));
    }
}

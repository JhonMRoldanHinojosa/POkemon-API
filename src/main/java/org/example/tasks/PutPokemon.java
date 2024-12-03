package org.example.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutPokemon implements Task {
    private final String id, name, url;

    public PutPokemon(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public static Performable withDetails(String id, String name, String url) {
        return instrumented(PutPokemon.class, id, name, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to("/pokemon/" + id).with(request -> request
                .contentType(ContentType.JSON)
                .body("{\"name\":\"" + name + "\",\"url\":\"" + url + "\"}")
                .log().all()));
    }
}


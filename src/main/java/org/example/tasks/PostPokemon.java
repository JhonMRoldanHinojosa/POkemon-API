package org.example.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPokemon implements Task {
    private final String name, url;

    public PostPokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public static Performable withDetails(String name, String url) {
        return instrumented(PostPokemon.class, name, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/pokemon").with(request -> request
                .contentType(ContentType.JSON)
                .body("{\"name\":\"" + name + "\",\"url\":\"" + url + "\"}")
                .log().all()));
    }
}


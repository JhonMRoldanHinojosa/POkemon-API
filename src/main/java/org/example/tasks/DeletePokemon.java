package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePokemon implements Task {
    private final String id;

    public DeletePokemon(String id) {
        this.id = id;
    }

    public static Performable withId(String id) {
        return instrumented(DeletePokemon.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from("/pokemon/" + id));
    }
}

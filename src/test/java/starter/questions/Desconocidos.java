package starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import starter.models.unknown.Unknown;

public class Desconocidos implements Question {

    @Override
    public Unknown answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Unknown.class);
    }
}

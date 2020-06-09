package starter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import starter.models.unknown.DatumU;
import starter.models.users.Datum;
import starter.questions.CodigoRespuesta;
import starter.questions.Desconocidos;
import starter.questions.Usuarios;
import starter.tasks.GetStatusCode;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SerenityRunner.class)
public class CucumberTestSuite {
    private String endPoint = "http://localhost:5000";

    @Test
    public void getUsers() {
        Actor hector = Actor.named("Hector")
                .whoCan(CallAnApi.at(endPoint));
        hector.attemptsTo(
                GetStatusCode.respuesta("/api/users?page=1")
        );
        hector.should(
                seeThat("El codigo de respuesta", CodigoRespuesta.codigo(), equalTo(200))
        );
        Datum user = new Usuarios().answeredBy(hector).getData()
                .stream().filter(x -> x.getId() == 1).findFirst().orElse(null);
        hector.should(
                seeThat("Usuario existe", ac -> user, notNullValue())
        );
        hector.should(
                seeThat("El nombre del usuario", ac -> user.getFirstName(), equalTo("George"))
        );
    }

    @Test
    public void getUnknown() {
        Actor hector = Actor.named("Hector")
                .whoCan(CallAnApi.at(endPoint));
        hector.attemptsTo(
                GetStatusCode.respuesta("/api/unknown")
        );
        hector.should(
                seeThat("El codigo de respuesta", CodigoRespuesta.codigo(), equalTo(200))
        );
        DatumU user = new Desconocidos().answeredBy(hector).getData()
                .stream().filter(x -> x.getId() == 3).findFirst().orElse(null);
        hector.should(
                seeThat("Usuario existe", ac -> user, notNullValue())
        );
        hector.should(
                seeThat("El nombre del usuario", ac -> user.getPantoneValue(), equalTo("19-1664"))
        );
    }
}

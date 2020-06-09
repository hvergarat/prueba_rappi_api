package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetStatusCode implements Task {

    private final String path;

    public GetStatusCode(String path) {
        this.path = path;
    }


    public static Performable respuesta(String path) {
        return new GetStatusCode(path);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Get.resource(path)
        );
    }
}

package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import ui.MainPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTask implements Task {

    String url;

    public OpenTask(String url) {
        this.url = url;
    }
    public static OpenTask abrir(String url) {
        return instrumented(OpenTask.class, url);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(url),
            Click.on(MainPage.POPUP_LOGIN_BUTTON)
        );
    }
}

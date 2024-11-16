package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.SeleccionHotelPage;
import utils.Util;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionHotelTask implements Task {

    public static SeleccionHotelTask seleccionarHotelBarato() {
        return instrumented(SeleccionHotelTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeleccionHotelPage.HOTEL_SELECCIONADO)
        );
        // Cambiar a la nueva pestaña
        Util.cambiarAProximaPestana(actor);
    }
}

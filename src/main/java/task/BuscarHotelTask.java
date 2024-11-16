package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ui.MainPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarHotelTask implements Task {
    private final String destino;
    private final String checkin;
    private final String checkout;
    private final Integer habitaciones;
    private final Integer adultos;
    private final Integer ninos;

    public BuscarHotelTask(String destino, String checkin, String checkout, Integer habitaciones, Integer adultos, Integer ninos) {
        this.destino = destino;
        this.checkin = checkin;
        this.checkout = checkout;
        this.habitaciones = habitaciones;
        this.adultos = adultos;
        this.ninos = ninos;
    }

    public static BuscarHotelTask buscarPorFiltros(String destino, String checkin, String checkout, Integer habitaciones, Integer adultos, Integer ninos) {
        return instrumented(BuscarHotelTask.class, destino, checkin, checkout, habitaciones, adultos, ninos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String checkinXpath = String.format("//span[@data-date='%s']", checkin);
        String checkoutXpath = String.format("//span[@data-date='%s']", checkout);
        actor.attemptsTo(
                Click.on(MainPage.DESTINO_FIELD),
                Enter.theValue(destino).into(MainPage.DESTINO_FIELD),
                Wait.until(
                        WebElementQuestion.the(MainPage.AUTOCOMPLETE_DESTINO_FIELD) , WebElementStateMatchers.isCurrentlyVisible()
                ).forNoLongerThan(30).seconds(),
                Click.on(MainPage.AUTOCOMPLETE_DESTINO_FIELD),
                Click.on(MainPage.FECHA_FIELD),
                Click.on(MainPage.FECHA_FIELD),
                Wait.until(
                        WebElementQuestion.the(checkinXpath) , WebElementStateMatchers.isCurrentlyVisible()
                ).forNoLongerThan(30).seconds(),
                Click.on(checkinXpath),
                Click.on(checkoutXpath),
                Click.on(MainPage.OCUPANTES_FIELD),
                Click.on(MainPage.ADULTOS_FIELD),
                Click.on(MainPage.NINOS_FIELD),
                Click.on(MainPage.NINOS_FIELD),
                Click.on(MainPage.HABITACIONES_FIELD),
                Click.on(MainPage.HABITACIONES_FIELD),
                SelectFromOptions.byValue(ninos.toString()).from(MainPage.EDAD_FIELD),
                Click.on(MainPage.OCUPANTES_FIELD)
        );
        //obtenemos la instancia del webdriver actual
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> listaEdades = driver.findElements(By.xpath(MainPage.EDAD_FIELD.getCssOrXPathSelector()));
        // Crea una instancia de Select y selecciona la opción por valor
        Select select = new Select(listaEdades.get(ninos-1));
        select.selectByValue(ninos.toString());
        actor.attemptsTo(
                Click.on(MainPage.BUSCAR_BUTTON),
                Click.on(MainPage.TRES_ESTRELLAS_CHECK),
                Click.on(MainPage.CUATRO_ESTRELLAS_CHECK),
                Click.on(MainPage.CINCO_ESTRELLAS_CHECK),
                Click.on(MainPage.FILTRO_BUTTON),
                Click.on(MainPage.OPCION_BAJO_PRECIO)
//                Click.on(MainPage.RD_PRECIO)
        );

    }
}

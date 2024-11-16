package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.DatosHotel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.ValidarHotelQuestion;
import task.BuscarHotelTask;
import task.OpenTask;
import task.SeleccionHotelTask;
import utils.Util;


public class ReservaStepDefinitions {
    private Actor user;
    @Managed(driver = "chrome")
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        user = Actor.named("Tester");
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("El usuario entra en la pagina principal de booking")
    public void ingresoPaginaPrincipal() {
        user.attemptsTo(OpenTask.abrir("https://www.booking.com/"));
    }
    @When("^El usuario ingresara los datos de filtro para el hotel (.*)$")
    public void ingresoFiltrosHotel(String ciudad) {
        user.attemptsTo(BuscarHotelTask.buscarPorFiltros(ciudad,
                Util.obtenerFechaActualMasDias(2), Util.obtenerFechaActualMasDias(7),2, 3, 2));
    }

    @When("El usuario selecciona el hotel mas barato")
    public void seleccionarHotelBarato() {
        user.attemptsTo(SeleccionHotelTask.seleccionarHotelBarato());
    }
    @Then("EL usuario visualizara una pantalla de confirmacion de reserva")
    public void visualizarConfirmacionReserva() {
        DatosHotel datosHotel = ValidarHotelQuestion.value().answeredBy(user);
        boolean devolvioDatosHotel = !datosHotel.getNombre().isEmpty();
        user.attemptsTo(
                Ensure.that(devolvioDatosHotel).isTrue()
        );
        if (devolvioDatosHotel) {
            Util.guardarDatosEnArchivo(datosHotel);
        }
    }
}

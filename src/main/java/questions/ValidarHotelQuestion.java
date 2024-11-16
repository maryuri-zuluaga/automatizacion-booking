package questions;

import model.DatosHotel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.SeleccionHotelPage;

@Subject("Validar si se selecciono hotel y esta listo para reservar")
public class ValidarHotelQuestion implements Question<DatosHotel> {
    @Override
    public DatosHotel answeredBy(Actor actor) {
        DatosHotel datosHotel = new DatosHotel();
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        datosHotel.setNombre(driver.findElement(By.xpath(SeleccionHotelPage.NOMBRE_FIELD.getCssOrXPathSelector())).getText());
        datosHotel.setPrecio(driver.findElement(By.xpath(SeleccionHotelPage.PRECIO_FIELD.getCssOrXPathSelector())).getText());
        datosHotel.setAnfitrion(driver.findElement(By.xpath(SeleccionHotelPage.ANFITRION_FIELD.getCssOrXPathSelector())).getText());
        return datosHotel;
    }

    public static Question<DatosHotel> value() { return new ValidarHotelQuestion(); }
}

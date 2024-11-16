package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {
//    public static final Target USERNAME_FIELD = Target
//            .the("Username field")
//            .locatedBy("#username");
//
//    public static final Target PASSWORD_FIELD = Target
//            .the("Password field")
//            .locatedBy("#password");

    public static final Target POPUP_LOGIN_BUTTON = Target
            .the("POPUP LOGIN NUEVA CUENTA")
            .locatedBy(".f4552b6561 svg");

    public static final Target DESTINO_FIELD = Target
            .the("CAMPO DESTINO")
            .locatedBy("#\\3Arh\\3A");

    public static final Target AUTOCOMPLETE_DESTINO_FIELD = Target
            .the("AUTOCOMPLETE CAMPO DESTINO")
            .locatedBy("#autocomplete-result-0 .a3332d346a");

    public static final Target FECHA_FIELD = Target
            .the("CAMPO FECHA")
            .locatedBy(".ebbedaf8ac:nth-child(2) > .a8887b152e");

    public static final Target OCUPANTES_FIELD = Target
            .the("CAMPO OCUPANTES")
            .locatedBy(".c7ce171153");

    public static final Target ADULTOS_FIELD = Target
            .the("campo adultos")
            .locatedBy(".a7a72174b8:nth-child(1) .f4d78af12a svg");

    public static final Target NINOS_FIELD = Target
            .the("campo niños")
            .locatedBy(".a7a72174b8:nth-child(2) .f4d78af12a svg");

    public static final Target EDAD_FIELD = Target
            .the("campo EDAD")
            .locatedBy("//select[@name='age']");

    public static final Target HABITACIONES_FIELD = Target
            .the("campo habitaciones")
            .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Habitaciones'])[1]/following::*[name()='svg'][2]");

    public static final Target BUSCAR_BUTTON = Target
            .the("BOTON BUSCAR")
            .locatedBy("//span[contains(.,'Buscar')]");

    public static final Target TRES_ESTRELLAS_CHECK = Target
            .the("CHECK 3")
            .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Encuentra hoteles y alquileres vacacionales de alta calidad'])[1]/following::*[name()='svg'][2]");

    public static final Target CUATRO_ESTRELLAS_CHECK = Target
            .the("CHECK 4")
            .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Encuentra hoteles y alquileres vacacionales de alta calidad'])[1]/following::*[name()='svg'][3]");

    public static final Target CINCO_ESTRELLAS_CHECK = Target
            .the("CHECK 5")
            .locatedBy("(.//*[normalize-space(text()) and normalize-space(.)='Encuentra hoteles y alquileres vacacionales de alta calidad'])[1]/following::*[name()='svg'][4]");

    public static final Target FILTRO_BUTTON = Target
            .the("BOTON FILTRO")
            .locatedBy("//div[@id='bodyconstraint-inner']/div[2]/div/div[2]/div[3]/div[2]/div[2]/div/div/div/div/span/button/span/span[2]");

    public static final Target OPCION_BAJO_PRECIO= Target
            .the("OPCION BAJO PRECIO")
            .locatedBy("//li[3]/button/div/div/span");

    public static final Target RD_PRECIO= Target
            .the("rdboton precio")
            .locatedBy("//fieldset/div[2]/div[2]/div/div");
}

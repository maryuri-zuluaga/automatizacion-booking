package ui;

import net.serenitybdd.screenplay.targets.Target;

public class SeleccionHotelPage {

    public static final Target HOTEL_SELECCIONADO= Target
            .the("hotel barato")
            .locatedBy("//div[@id='bodyconstraint-inner']/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div/div/div/div/div/div/h3/a/div");

    public static final Target NOMBRE_FIELD= Target
            .the("CAMPO NOMBRE")
            .locatedBy("//div[@id='hp_hotel_name']/div/h2");

    public static final Target PRECIO_FIELD= Target
            .the("CAMPO PRECIO")
            .locatedBy("//table[@id='hprt-table']/tbody/tr/td[3]/div/div/div/div[2]/div/span");

    public static final Target ANFITRION_FIELD= Target
            .the("CAMPO ANFITRION")
            .locatedBy("//div[@id='basiclayout']/div/div[8]/div/div[6]/div/header/div/h2/div");
}

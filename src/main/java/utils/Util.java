package utils;

import model.DatosHotel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Util {
    public static void cambiarAProximaPestana(Actor actor) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Set<String> ventanas = driver.getWindowHandles();
        String ventanaPrincipal = driver.getWindowHandle();

        for (String ventana : ventanas) {
            if (!ventana.equals(ventanaPrincipal)) {
                driver.switchTo().window(ventana);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break;
            }
        }
    }
    public static void guardarDatosEnArchivo(DatosHotel datosHotel) {
        // Obtenemos el nombre del hotel
        String nombreHotel = datosHotel.getNombre();

        // Si el nombre del hotel no es vacío
        if (nombreHotel != null && !nombreHotel.isEmpty()) {
            // Nombre del archivo, usando el nombre del hotel
            String nombreArchivo = "ReservaHotel-" + nombreHotel + ".txt";

            // Ruta del archivo en la raíz del proyecto
            File archivo = new File(nombreArchivo);

            try {
                // Crear un BufferedWriter para escribir el archivo
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

                // Escribir los datos del hotel en el archivo
                writer.write("Nombre del Hotel: " + datosHotel.getNombre());
                writer.newLine();
                writer.write("Precio: " + datosHotel.getPrecio());
                writer.newLine();
                writer.write("Anfitrion: "+ datosHotel.getAnfitrion());
                // Cerrar el archivo
                writer.close();

                // Imprimir mensaje de éxito
                System.out.println("Los datos del hotel se han guardado en: " + nombreArchivo);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ocurrió un error al guardar los datos en el archivo.");
            }
        } else {
            System.out.println("El nombre del hotel está vacío, no se guardarán datos.");
        }
    }

    public static String obtenerFechaActualMasDias(Integer dias){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMasDias = fechaActual.plusDays(dias);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaMasDias.format(formatter);
    }
}

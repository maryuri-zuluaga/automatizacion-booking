package stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupConfiguration {
    public static Actor User = Actor.named("User");
    private WebDriver driver;

    @Before
    public void setUp() {
        User= Actor.named("User").can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
        driver = new ChromeDriver();
    }
}

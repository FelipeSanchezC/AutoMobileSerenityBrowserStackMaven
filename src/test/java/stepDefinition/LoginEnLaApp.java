package stepDefinition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.Yaml;
import tasks.DesplazarLogin;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginEnLaApp {

    AndroidDriver driver;


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario");

    }

    @After
    public void tearDown() {

    }

/*    public void createDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        driver = new AndroidDriver(options);
    }*/



    public void createDriver() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("browserstack.yml")) {
            if (inputStream == null) {
                throw new RuntimeException("browserstack.yml file not found");
            }

            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);

            UiAutomator2Options options = new UiAutomator2Options();
            options.setCapability("browserstack.user", config.get("userName"));
            options.setCapability("browserstack.key", config.get("accessKey"));
            options.setCapability("app", config.get("app"));
            options.setCapability("device", ((Map<String, String>) ((Map<String, Object>) config.get("platforms")).get(0)).get("deviceName"));
            options.setCapability("os_version", ((Map<String, String>) ((Map<String, Object>) config.get("platforms")).get(0)).get("platformVersion"));
            options.setCapability("project", config.get("projectName"));
            options.setCapability("build", config.get("buildName"));
            options.setCapability("name", "Login Test");

            driver = new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), options);
            OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(driver));
            System.out.println("Driver initialized: " + driver.getClass().getName());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize BrowserStack driver", e);
        }
    }

    @Given("Me desplazo al menu del login")
    public void ingresoLogin(){
        createDriver();
        System.out.println("***********************************Driver initialized: " + driver.getClass().getName());

        theActorCalled("Usuario").can(BrowseTheWeb.with(getDriver()));
        System.out.println(" -------------------------  El driver es :" + getDriver().toString());
        theActorInTheSpotlight().attemptsTo(
                DesplazarLogin.inTheApp()
        );
    }

    @When("Ingreso Usuario {} con clave {}")
    public void ingresoCredenciales(String usuario, String clave){
        theActorInTheSpotlight().attemptsTo(

        );
    }

    @Then("Valido login exitoso")
    public void validarLoginExitoso(){

    }


}

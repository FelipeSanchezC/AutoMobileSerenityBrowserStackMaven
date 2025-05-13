package tasks;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userInterfaces.HomeUi.MENU_HOME;
import static userInterfaces.HomeUi.OPCION_MENU_LOGIN;

public class DesplazarLogin implements Task {



    public static DesplazarLogin inTheApp(){
        return instrumented(DesplazarLogin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(MENU_HOME, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(MENU_HOME),
                Click.on(OPCION_MENU_LOGIN)
        );

    }


}

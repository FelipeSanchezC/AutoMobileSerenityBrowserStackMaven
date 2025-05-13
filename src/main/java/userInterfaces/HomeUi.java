package userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUi {

    private HomeUi(){}

    public static final Target MENU_HOME = Target
            .the("Menu superior en la pantalla Home")
            .located(AppiumBy.id("com.Advantage.aShopping:id/imageViewMenu")); //  located(By.id("imageViewMenu"));


    public static final Target OPCION_MENU_LOGIN = Target
            .the("Opcion del menu del Home para iniciar proceso del login")
            .located(AppiumBy.id("com.Advantage.aShopping:id/textViewMenuUser"));


}

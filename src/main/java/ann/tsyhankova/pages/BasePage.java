package ann.tsyhankova.pages;

import ann.tsyhankova.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public interface BasePage<T extends BasePage> {

    WebDriver driver = DriverFactory.getInstance();

    T open();
}

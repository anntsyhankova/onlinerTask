package ann.tsyhankova.factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getInstance(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(30));
        driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        driver.manage().window().maximize();
        return driver;
    }

}

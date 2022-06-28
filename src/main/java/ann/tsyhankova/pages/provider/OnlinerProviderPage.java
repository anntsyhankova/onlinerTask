package ann.tsyhankova.pages.provider;

import ann.tsyhankova.pages.BasePage;
import org.openqa.selenium.By;

public class OnlinerProviderPage implements BasePage<OnlinerProviderPage> {

    private final By providerName = By.xpath("//h1[@class='sells-title']");

    public String getProviderName(){
        return driver.findElement(providerName).getText();
    }

    @Override
    public OnlinerProviderPage open() {
        return null;
    }
}

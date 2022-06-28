package ann.tsyhankova.pages.productCard.elements;

import ann.tsyhankova.pages.provider.OnlinerProviderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OfferWrapper {

    final private WebElement element;
    final private By providerNameText = By.xpath("//a[contains(@class,'offers-list__description')]");
    final private By providerButton = By.xpath("//a[contains(@class,'offers-list__preview')]");

    public OfferWrapper(WebElement element) {
        this.element = element;
    }

    public OnlinerProviderPage goToProviderPage(){
        if (!this.element.findElements(providerButton).isEmpty()){
            this.element.findElement(providerButton).click();
        } else if (!this.element.findElements(providerNameText).isEmpty()) {
            this.element.findElement(providerNameText).click();
        }
        return new OnlinerProviderPage();
    }

}

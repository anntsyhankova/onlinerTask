package ann.tsyhankova.pages.main.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SimpleCatalogNavigationMenuItem {

    private final WebElement element;
    private final By buttonName = By.xpath(".//span[contains(@class,'catalog-navigation-classifier__item-title-wrapper')]");

    public SimpleCatalogNavigationMenuItem(WebElement element) {
        this.element = element;
    }

    public String getButtonName(){
        return this.element.findElement(buttonName).getText();
    }

    public void click(){
        this.element.click();
    }
}

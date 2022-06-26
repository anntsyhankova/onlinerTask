package ann.tsyhankova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationButton {

    private final WebElement element;

    private final By buttonName = By.xpath(".//span[contains(@class,'catalog-navigation-classifier__item-title-wrapper')]");

    public NavigationButton(WebElement element) {
        this.element = element;
    }

    public String getButtonName(){
        return this.element.findElement(buttonName).getText();
    }

    public void click(){
        this.element.click();
    }
}

package ann.tsyhankova.pages.main.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CatalogNavigationMenuItem {

    private final WebElement element;
    private final By catalogItemName = By.xpath(".//div[@class='catalog-navigation-list__aside-title']");

    public CatalogNavigationMenuItem(WebElement element) {
        this.element = element;
    }

    public String getCatalogItemName(){
        return this.element.findElement(catalogItemName).getText();
    }

    public void click(){
        this.element.click();
    }
}

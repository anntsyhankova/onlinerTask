package ann.tsyhankova.pages.main.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CatalogNavigationSectionItem {

    private final WebElement element;
    private final By sectionItemName = By.xpath(".//span[@class='catalog-navigation-list__dropdown-title']");

    public CatalogNavigationSectionItem(WebElement element){
        this.element = element;
    }

    public String getSectionItemName(){
        return this.element.findElement(sectionItemName).getText();
    }

    public void click(){
        this.element.click();
    }
}

package ann.tsyhankova.pages.search.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterItem {

    private final WebElement element;
    private final By filterItemName = By.xpath(".//span");

    public FilterItem(WebElement element) {
        this.element = element;
    }

    public String getFilterItemName(){
        return this.element.findElement(filterItemName).getText();
    }

    public WebElement getElement(){
        return this.element;
    }

    public void click(){
        this.element.click();
    }
}

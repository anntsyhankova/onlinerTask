package ann.tsyhankova.pages.search.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SimpleFilter {

    private final FilterItem filter;
    private final By fromDropdownSelector = By.xpath(".//div[contains(@class,'schema-filter-control')][1]/select");
    private final By toDropdownSelector = By.xpath(".//div[contains(@class,'schema-filter-control')][2]/select");
    private final By dropdownOptions = By.xpath(".//option");

    public SimpleFilter(FilterItem filter){
        this.filter = filter;
    }

    public void from(String value){
        Select fromDropdown = new Select(this.filter.getElement().findElement(fromDropdownSelector));
        fromDropdown.selectByVisibleText(value);
    }

    public WebElement to(String value){
        return null;
    }

    public WebElement equal(String value){
        return null;
    }

    private List<WebElement> getDropdownOptions(WebElement dropdown){
        return dropdown.findElements(dropdownOptions);
    }

    public void click(){
        this.filter.click();
    }
}

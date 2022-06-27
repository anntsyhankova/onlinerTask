package ann.tsyhankova.pages.search.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class FilterSection {

    private final WebElement element;
    private final By filterItemList = By.xpath(".//div[@class='schema-filter__fieldset']");

    public FilterSection(WebElement element){
        this.element = element;
    }

    public FilterItem findFilterWithName(String filterName){
        return getFilterList().stream()
                .filter(filterItem -> filterName.equals(filterItem.getFilterItemName()))
                .findFirst()
                .orElse(null);
    }

    private List<FilterItem> getFilterList(){
        return element.findElements(filterItemList).stream()
                .map(FilterItem::new)
                .collect(Collectors.toList());
    }
}

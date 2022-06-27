package ann.tsyhankova.pages.main.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogNavigationSection {

    private final WebElement element;
    private final By menuItemList = By.xpath(".//div[@class='catalog-navigation-list__aside-item']");
    private final By sectionItemList = By.xpath(".//a[@class='catalog-navigation-list__dropdown-item']");

    public CatalogNavigationSection(WebElement element){
        this.element = element;
    }

    public List<CatalogNavigationMenuItem> getMenuItems(){
        return element.findElements(menuItemList).stream()
                .map(CatalogNavigationMenuItem::new)
                .collect(Collectors.toList());
    }

    public CatalogNavigationSection clickOnMenuItemWithName(String menuItemName){
        findMenuItemByName(menuItemName).click();
        return this;
    }

    public CatalogNavigationMenuItem findMenuItemByName(String menuItemName){
        return getMenuItems().stream()
                .filter(menuItem -> menuItemName.equals(menuItem.getCatalogItemName()))
                .findFirst()
                .orElse(null);
    }

    public List<CatalogNavigationSectionItem> getItems(){
        return element.findElements(sectionItemList).stream()
                .map(CatalogNavigationSectionItem::new)
                .collect(Collectors.toList());
    }

    public CatalogNavigationSectionItem findSectionItemByName(String sectionItemName){
        return getItems().stream()
                .filter(sectionItem -> sectionItemName.equals(sectionItem.getSectionItemName()))
                .findFirst()
                .orElse(null);
    }


}

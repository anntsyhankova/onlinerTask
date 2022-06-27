package ann.tsyhankova.pages.main.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SimpleCatalogNavigationMenu {

    private final WebElement element;
    private final By catalogButton = By.xpath(".//li[contains(@class, 'catalog-navigation-classifier__item')]");

    public SimpleCatalogNavigationMenu(WebElement element){
        this.element = element;
    }

    public SimpleCatalogNavigationMenuItem findButtonByName(String buttonName){
        return getNavigationButtonList()
                .stream()
                .filter(navigationButton -> buttonName.equals(navigationButton.getButtonName()))
                .findFirst()
                .orElse(null);
    }

    private List<SimpleCatalogNavigationMenuItem> getNavigationButtonList(){
        return this.element.findElements(catalogButton).stream().map(SimpleCatalogNavigationMenuItem::new).toList();
    }
}

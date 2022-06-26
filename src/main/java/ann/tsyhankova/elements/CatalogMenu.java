package ann.tsyhankova.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogMenu {

    private final WebElement element;
    private final By catalogButton = By.xpath(".//li[contains(@class, 'catalog-navigation-classifier__item')]");

    public CatalogMenu(WebElement element){
        this.element = element;
    }

    public void findButtonByName(String buttonName){
        getNavigationButtonList()
                .stream()
                .filter(navigationButton -> buttonName.equals(navigationButton.getButtonName()))
                .findFirst()
                .orElse(null)
                .click();
    }

    private List<NavigationButton> getNavigationButtonList(){
        return this.element.findElements(catalogButton).stream().map(NavigationButton::new).toList();
    }
}

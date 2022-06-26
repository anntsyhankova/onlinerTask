package ann.tsyhankova.pages;

import ann.tsyhankova.elements.CatalogMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class OnlinerMainPage implements BasePage<OnlinerMainPage>{

    private final By catalogMenu = By.xpath("//ul[@class='catalog-navigation-classifier ']");

    public OnlinerResultPage chooseCategory(String buttonName){
        findCatalogNavigationMenu().findButtonByName(buttonName);

        return null;
    }

    public CatalogMenu findCatalogNavigationMenu() {
        WebElement catalogMenu = driver.findElement(this.catalogMenu);
        return new CatalogMenu(catalogMenu);
    }

    @Override
    public OnlinerMainPage open() {
        driver.get("https://catalog.onliner.by");
        return this;
    }
}

package ann.tsyhankova.pages.main;

import ann.tsyhankova.pages.main.elements.CatalogNavigationSection;
import ann.tsyhankova.pages.main.elements.SimpleCatalogNavigationMenu;
import ann.tsyhankova.pages.BasePage;
import ann.tsyhankova.pages.search.OnlinerSearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OnlinerMainPage implements BasePage<OnlinerMainPage> {

    private final By simpleCatalogNavigationMenu = By.xpath("//ul[@class='catalog-navigation-classifier ']");
    private final By catalogSection = By.xpath("//div[@class='catalog-navigation-list__wrapper']");

    public OnlinerSearchResultPage chooseCategory(String nabigationButtonName, String categoryGroupName, String categoryItemName){
        findSimpleCatalogNavigationMenu().findButtonByName(nabigationButtonName).click();
        findCatalogNavigationSection().clickOnMenuItemWithName(categoryGroupName).findSectionItemByName(categoryItemName).click();
        return new OnlinerSearchResultPage();
    }

    public SimpleCatalogNavigationMenu findSimpleCatalogNavigationMenu() {
        return new SimpleCatalogNavigationMenu(driver.findElement(this.simpleCatalogNavigationMenu));
    }

    public CatalogNavigationSection findCatalogNavigationSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return new CatalogNavigationSection(wait.until(ExpectedConditions.presenceOfElementLocated(catalogSection)));
    }

    @Override
    public OnlinerMainPage open() {
        driver.get("https://catalog.onliner.by");
        return this;
    }
}

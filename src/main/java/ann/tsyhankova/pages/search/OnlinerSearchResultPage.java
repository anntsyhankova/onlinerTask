package ann.tsyhankova.pages.search;

import ann.tsyhankova.pages.search.elements.FilterSection;
import ann.tsyhankova.pages.search.elements.ProductWrapper;
import ann.tsyhankova.pages.search.elements.SimpleFilter;
import ann.tsyhankova.pages.BasePage;
import ann.tsyhankova.pages.productCard.OnlinerProductCardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OnlinerSearchResultPage implements BasePage<OnlinerSearchResultPage> {

    private final By filterSection = By.xpath("//div[@class='schema-filter__wrapper']");
    private final By productList = By.xpath("//div[@class='schema-product']");

    public OnlinerSearchResultPage chooseFilterByNameAndInputFromValue(String filterName, String value){
        new SimpleFilter(findFilterSection().findFilterWithName(filterName)).from(value);
        return this;
    }

    public OnlinerProductCardPage goToProductCardPage(ProductWrapper productCard){
        productCard.clickOffersButton();
        return new OnlinerProductCardPage();
    }
    public List<ProductWrapper> getProductList(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException("Cannot wait 1s before get product list", e);
        }
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList)).stream()
                .map(ProductWrapper::new)
                .toList();
    }

    public FilterSection findFilterSection() {
        return new FilterSection(driver.findElement(filterSection));
    }

    public OnlinerSearchResultPage render(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productList));
        return this;
    }
    @Override
    public OnlinerSearchResultPage open() {
        return null;
    }
}

package ann.tsyhankova.pages.search.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ProductWrapper {

    private final WebElement element;
    private final By priceSelector = By.xpath(".//a[contains(@class,'schema-product__price-value')]//span[1]");
    private final By productOffersButton = By.xpath(".//div[@class='schema-product__offers'][1]");

    public ProductWrapper(WebElement element) {
        this.element = element;
    }

    public Double getPrice(){
        return Double.parseDouble(
                this.element.findElement(priceSelector).getText()
                        .split(" ")[0]
                        .replace(',', '.'));
    }

    public void clickOffersButton(){
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException("Cannot wait 1s before get product list", e);
        }
        this.element.findElement(productOffersButton).click();
    }
}

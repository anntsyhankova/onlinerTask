package ann.tsyhankova.pages.search.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ProductWrapper {

    private final WebElement element;
    private final By priceSelector = By.xpath(".//div[@class='schema-product__price']//span[1]");
    private final By productOffersButton = By.xpath(".//div[@class='schema-product__offers'][1]");

    public ProductWrapper(WebElement element) {
        this.element = element;
    }

    public Double getPrice(){
        //NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
//        String value = this.element.findElement(priceSelector)
//                .getText().split(" ")[0];
        return Double.parseDouble(
                this.element.findElement(priceSelector).getText()
                        .split(" ")[0]
                        .replace(',', '.'));
//        try {
//            return format.parse(value).doubleValue();
//        } catch (ParseException e) {
//            throw new RuntimeException("Cannot parse value from price", e);
//        }
    }

    public void clickOffersButton(){
        this.element.findElement(productOffersButton).click();
    }
}

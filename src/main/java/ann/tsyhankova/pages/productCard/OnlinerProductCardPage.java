package ann.tsyhankova.pages.productCard;

import ann.tsyhankova.pages.BasePage;
import ann.tsyhankova.pages.productCard.elements.OfferWrapper;
import org.openqa.selenium.By;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class OnlinerProductCardPage implements BasePage<OnlinerProductCardPage> {

    private final String url;
    private final By anotherOffersButton = By.xpath("//span[contains(@class, 'offers-list__button_show')]");
    private final By offerCardList = By.xpath("//div[@class='offers-list__item']");
    public OnlinerProductCardPage(){
        this.url = driver.getCurrentUrl();
        System.out.println(this.url);
    }

    public List<OfferWrapper> getAllOfferList(){
        System.out.println(new Timestamp(System.currentTimeMillis()));
        if (!driver.findElements(anotherOffersButton).isEmpty()){
            driver.findElement(anotherOffersButton).click();
        }
        System.out.println(new Timestamp(System.currentTimeMillis()));
        return getOfferList();
    }

    public List<OfferWrapper> getOfferList(){
        return driver.findElements(offerCardList).stream().map(OfferWrapper::new).toList();
    }

    @Override
    public OnlinerProductCardPage open() {
        driver.get(this.url);
        return new OnlinerProductCardPage();
    }
}

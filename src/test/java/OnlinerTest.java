import ann.tsyhankova.pages.productCard.OnlinerProductCardPage;
import ann.tsyhankova.pages.productCard.elements.OfferWrapper;
import ann.tsyhankova.pages.search.elements.ProductWrapper;
import ann.tsyhankova.pages.main.OnlinerMainPage;
import ann.tsyhankova.pages.search.OnlinerSearchResultPage;
import ann.tsyhankova.pages.search.elements.SimpleFilter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OnlinerTest {

    @Test
    public void openTest() {
        List<String> providerNameList = new ArrayList<>();
        ProductWrapper productWrapper = new OnlinerMainPage().open()
                .chooseCategory(
                        "Компьютеры и сети",
                        "Комплектующие",
                        "Видеокарты")
                .render()
                .chooseFilterByNameAndInputFromValue("Видеопамять", "8 ГБ")
                .render()
                .getProductList().stream()
                .max(Comparator.comparing(ProductWrapper::getPrice))
                .orElse(null);
        System.out.println(productWrapper.getPrice());
        OnlinerProductCardPage page = new OnlinerSearchResultPage().goToProductCardPage(productWrapper);
        for (int i = 0; i < page.getAllOfferList().size(); i++) {
            List<OfferWrapper> offerWrapperList = page.getAllOfferList();
            providerNameList.add(offerWrapperList.get(i).goToProviderPage().getProviderName());
            page.open();
        }
        System.out.println(providerNameList);
    }

    public void test(){
        //open graphics card category search page
        new OnlinerMainPage().open()
                .findSimpleCatalogNavigationMenu()
                .findButtonByName("Компьютеры и сети")
                .click();
        new OnlinerMainPage()
                .findCatalogNavigationSection()
                .findMenuItemByName("Комплектующие")
                .click();
        new OnlinerMainPage()
                .findCatalogNavigationSection()
                .findSectionItemByName("Видеокарты")
                .click();
        SimpleFilter filter = new SimpleFilter(
                new OnlinerSearchResultPage()
                .render()
                .findFilterSection().findFilterWithName("Видеопамять")
        );
        //Apply video memory filter - from value
        filter.from("8 ГБ");
        List<ProductWrapper> productList = new OnlinerSearchResultPage()
                .render()
                .getProductList();
        //get product with min price in List
        ProductWrapper minPriceProduct = productList.stream()
                .min(Comparator.comparing(ProductWrapper::getPrice)).orElse(null);
        minPriceProduct.clickOffersButton();
        //open product card page
        new OnlinerProductCardPage();
               // .render();
    }
}

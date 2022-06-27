import ann.tsyhankova.pages.search.elements.ProductWrapper;
import ann.tsyhankova.pages.main.OnlinerMainPage;
import ann.tsyhankova.pages.search.OnlinerSearchResultPage;
import org.testng.annotations.Test;

import java.util.Comparator;

public class OnlinerTest {

    @Test
    public void openTest(){
        ProductWrapper productWrapper = new OnlinerMainPage().open()
                .chooseCategory(
                        "Компьютеры и сети",
                        "Комплектующие",
                        "Видеокарты")
                .render()
                .chooseFilterByNameAndInputFromValue("Видеопамять", "8 ГБ")
                .render()
                .getProductList().stream()
                .min(Comparator.comparing(ProductWrapper::getPrice))
                .orElse(null);
        new OnlinerSearchResultPage().goToProductCardPage(productWrapper);
        System.out.println("Fuck You!");
        //new OnlinerMainPage().open().chooseCategory("Компьютеры и сети", "Комплектующие");
    }
}

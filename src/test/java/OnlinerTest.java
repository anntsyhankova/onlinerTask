import ann.tsyhankova.pages.OnlinerMainPage;
import org.testng.annotations.Test;

public class OnlinerTest {

    @Test
    public void openTest(){
        new OnlinerMainPage().open().chooseCategory("Компьютеры и сети");
    }
}

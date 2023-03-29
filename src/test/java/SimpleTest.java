import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest{
WebElement elem;
        @Test
    public void simpleTest() throws InterruptedException {

        openRztka();
            Thread.sleep(2000);

        MainPage mPage = new MainPage(driver);

        pushButton(driver);


        mPage.searchRPage.click();

            Thread.sleep(2000);
        SearchResultPage srPage = new SearchResultPage(driver);
        srPage.selectedPage.click();
            Thread.sleep(2000);
        SelectedPage sPage = new SelectedPage(driver);
        sPage.basketPage.click();
            Thread.sleep(2000);
        BasketPage basketPage = new BasketPage(driver);
        basketPage.orderedGoods.click();

        Thread.sleep(5000);
    }
}

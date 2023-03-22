import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDriverClass {
    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().arch64().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua");

        WebElement elem1 = driver.findElement(By.name("search"));
        elem1.sendKeys("Acer Aspire", Keys.ENTER);

        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'catalog-grid__cell')]//a[contains(@class,'goods-tile__heading')]"));

        driver.navigate().to(list.get(2).getAttribute("href"));
        Thread.sleep(2000);

        WebElement btnBuy = driver.findElement(By.xpath("//button[contains(@class, 'button--green button')]"));
        btnBuy.click();

        Thread.sleep(2000);
        WebElement btnNext = driver.findElement(By.xpath("//button[contains(@class, 'cart-footer__continue ng-star-inserted')]"));
        btnNext.click();

        Thread.sleep(2000);
        WebElement elem2 = driver.findElement(By.name("search"));
        elem2.sendKeys("FREGGIA", Keys.ENTER);

        Thread.sleep(2000);
        List<WebElement> list2 = driver.findElements(By.xpath("//li[contains(@class,'catalog-grid__cell')]//a[contains(@class,'goods-tile__heading')]"));

        driver.navigate().to(list2.get(2).getAttribute("href"));

        Thread.sleep(2000);
        WebElement btnBuy2 = driver.findElement(By.xpath("//button[contains(@class, 'button--green button')]")); //app-buy-button[@class='mode-slim toOrder ng-star-inserted']
        btnBuy2.click();

        Thread.sleep(2000);
        WebElement btnNext2 = driver.findElement(By.xpath("//button[contains(@class, 'cart-footer__continue ng-star-inserted')]"));
        btnNext2.click();

        Thread.sleep(2000);
        driver.close();
    }

}

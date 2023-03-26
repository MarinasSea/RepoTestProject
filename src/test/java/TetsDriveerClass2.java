import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TetsDriveerClass2 {

    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().arch64().setup();

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("disable-notifications");
        opt.addArguments("start-maximized");
        opt.addArguments("incognito");


        WebDriver driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua");


        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        //варіант, якщо я вірно зрозуміла відповідь на питання - це одразу пробувати передати спосок елементів, але як ми до нього дійдемо, якщо також нелистає до нього
        //в мене невеликий відчай вже
        List<WebElement> list2 = driver.findElements(By.xpath("(//h2[contains(text(),'Найбільш обговорювані товари')])[2]/following-sibling::ul/li"));
        jse.executeScript("arguments[0].ScrollIntoView(true);",list2);

/* пробую прокручувати сторінку до потрібного елемента - вже і це перестало працювати, недолистує

     /* Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,990)");
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,990)");
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,990)");
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

     WebElement elem1 = driver.findElement(By.xpath("(//h2[contains(text(),'Найбільш обговорювані товари')])[2]")); // (//rz-goods-section[@class='ng-star-inserted']//h2[contains(text(),'Найбільш обговорювані товари')])[2]
*/






      //////////////////////////////////////////////////////////////////////////


        /*  // (//h2[contains(text(),'Найбільш обговорювані товари')])[2]/following-sibling::ul/li//a[@class='tile__title']
        for(WebElement el : list2)
          System.out.println(el.findElement(By.xpath("//a[@class='tile__title']")).getText());
        Thread.sleep(3000);
        //driver.close();*/


    }
}

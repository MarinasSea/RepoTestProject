import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
      @BeforeClass
    public void initBrowser() {

        WebDriverManager.chromedriver().arch64().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");
        opt.addArguments("incognito");
        opt.addArguments("disable-notifications");

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void close(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    public void openRztka(){

        driver.get("https://rozetka.com.ua/ua/");
    }

    public void pushButton(WebDriver d){

        String prod = getPropValue("product");
/*
        switch (prod) {
            case "Acer Aspire":
                d.findElement(By.name("search")).sendKeys(prod);
                break;
            case "Asus":
                d.findElement(By.name("search")).sendKeys(prod);
                break;
        }*/
        d.findElement(By.name("search")).sendKeys(prod);

    }

    private String getPropValue(String propName){
        Properties prop = new Properties();
        try{
            FileInputStream f = new FileInputStream("src/test/resources/products.properties");
            prop.load(f);
        }catch(IOException ignored){}

        return prop.getProperty(propName, "Asus");
    }
}

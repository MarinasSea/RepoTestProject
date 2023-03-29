import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit ng-star-inserted')]")
    public WebElement searchRPage;
        public MainPage(WebDriver driver) {
            super(driver);
        }

 }

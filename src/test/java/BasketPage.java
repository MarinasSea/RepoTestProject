import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
    @FindBy(xpath = "//button[contains(@class, 'button--green button')]")

    public WebElement orderedGoods;

    public BasketPage(WebDriver driver) {
        super(driver);
    }
}

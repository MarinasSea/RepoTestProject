import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedPage extends BasePage{

    @FindBy(xpath = "(//rz-catalog-tile)[2]")
   // @FindBy(xpath = "(//a[@class='goods-tile__heading ng-star-inserted'])[2]")
    public WebElement basketPage;

    public SelectedPage(WebDriver driver) {
        super(driver);
    }
}

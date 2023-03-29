import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "(//ul[contains(@class, 'catalog-grid ng-star-inserted')]/li)[3]")
    public WebElement selectedPage;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}

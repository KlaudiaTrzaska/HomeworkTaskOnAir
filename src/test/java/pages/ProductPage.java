package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class ProductPage  extends BasePage {
    @FindBy(css = "div#ProductBuy>div>div>button")
    private WebElement addToCartButton;

    @FindBy(css = ".modal-footer>button[type='button']")
    private WebElement noThanksButton;

    @FindBy(css = ".modal-footer>button[class*='btn-primary']")
    private WebElement addProtectionButton;

    @FindBy(css = "div.message-title")
    private WebElement itemAddedMessageTitle;

    @FindBy(css = "button[title='View Cart']")
    private WebElement viewCartButton;

    public ProductPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage clickOnAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public ProductPage addItemWithoutProtection() {
        noThanksButton.click();
        return this;
    }

    public ProductPage addItemWithSelectedProtection() {
        addProtectionButton.click();
        return this;
    }

    public String getMessageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, timeout );
        wait.until(ExpectedConditions.visibilityOf(itemAddedMessageTitle));
        return itemAddedMessageTitle.getText().toLowerCase(Locale.ROOT);
    }

    public ProductPage openCartView() {
        viewCartButton.click();
        return this;
    }


}

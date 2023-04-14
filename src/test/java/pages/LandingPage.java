package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    @FindBy(css="button[class*='osano-cm-accept-all']")
    private WebElement acceptCookiesButton;

    @FindBy(css = "input[type='search']")
    private WebElement searchBox;

    @FindBy(css = "button[class$='search']")
    private WebElement searchIconButton;

    public LandingPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LandingPage acceptCookies() {
        acceptCookiesButton.click();
        return this;
    }

    public LandingPage searchItem(String itemName) {
        searchBox.sendKeys(itemName);
        searchIconButton.click();
        return this;
    }


}

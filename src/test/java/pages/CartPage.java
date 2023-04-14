package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(css = "a.item-title")
    public WebElement itemInTheCart;

    @FindBy(css = ".row-title-note")
    private WebElement shoppingCartItemsHeader;

    public CartPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getShoppingCartHeader(){
        return shoppingCartItemsHeader.getText();
    }
}

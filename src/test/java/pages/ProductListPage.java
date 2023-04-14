package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ProductListPage  extends BasePage {

    @FindBy(css="h1.page-title-text")
    private WebElement searchResultTitle;

    @FindBy(className = "result-message-error")
    private WebElement itemNotFoundErrorMessage;

    @FindBy(css = "a.item-title")
    private List<WebElement> itemsList;

    @FindBy(css = ".item-operate>div>button[title$='cart']")
    private WebElement addToCartButton;

    public ProductListPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getPageTitleText() {
        return searchResultTitle.getText().toLowerCase(Locale.ROOT);
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, timeout );
        wait.until(ExpectedConditions.visibilityOf(itemNotFoundErrorMessage));
        return itemNotFoundErrorMessage.getText();
    }

    public int getItemListSize() {
        return itemsList.size();
    }

    public List<String> getItemsTitles() {
        return itemsList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public ProductListPage openProduct() {
        WebElement item = driver.findElement(By.xpath(".//a[text()='Beyerdynamic DT 770 Pro 80 Ohm Studio Reference Closed-Back Headphones']"));
        item.click();
        return this;
    }

    public ProductListPage clickOnQuickView() {
        WebElement quickViewButton = driver.findElement(By.cssSelector("div[class$='btn-quickview']"));
        new Actions(driver)
                .moveToElement(quickViewButton)
                .perform();
        quickViewButton.click();
        return this;
    }

    public ProductListPage addItemToCart() {
        addToCartButton.click();
        return this;
    }
}

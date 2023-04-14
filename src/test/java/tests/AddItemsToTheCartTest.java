package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LandingPage;
import pages.ProductListPage;
import pages.ProductPage;

public class AddItemsToTheCartTest extends BaseTest {

    @Test
    public void addItemToTheCartTest() {
        LandingPage landingPage = new LandingPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        landingPage.searchItem("Beyerdynamic DT 770 Pro 80 Ohm Studio Reference Closed-Back Headphones");
        productListPage.openProduct();
        productPage
                .clickOnAddToCartButton()
                .addItemWithoutProtection();

        Assert.assertTrue(productPage.getMessageTitle().contains("item has been added to cart."));

        productPage.openCartView();
        cartPage.itemInTheCart.isDisplayed();
        Assert.assertEquals(cartPage.getShoppingCartHeader(), "(1 Item)");
    }

    @Test
    public void addItemToCartViaQuickViewTest(){
        LandingPage landingPage = new LandingPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        landingPage.searchItem("Beyerdynamic DT 770 Pro 80 Ohm Studio Reference Closed-Back Headphones");
        productListPage
                .clickOnQuickView()
                .addItemToCart();

        Assert.assertTrue(productPage.getMessageTitle().contains("item has been added to cart."));

        productPage.openCartView();
        cartPage.itemInTheCart.isDisplayed();
        Assert.assertEquals(cartPage.getShoppingCartHeader(), "(1 Item)");

    }
}

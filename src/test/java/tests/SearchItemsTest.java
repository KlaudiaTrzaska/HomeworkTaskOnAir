package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ProductListPage;

public class SearchItemsTest extends BaseTest {

    @Test
    public void searchItemsHappyPathTest() {
        LandingPage landingPage = new LandingPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);

        landingPage.searchItem("headphones");
        Assert.assertTrue(productListPage.getPageTitleText().contains("headphones"));
        Assert.assertTrue(productListPage.getItemsTitles().get(0).contains("Headphones"));
        Assert.assertTrue(productListPage.getItemListSize() > 1);

    }

    @Test
    public void searchItemNegativeTest() {
        LandingPage landingPage = new LandingPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);

        landingPage.searchItem("abcdefgh");
        Assert.assertTrue(productListPage.getErrorMessage().contains("We have found 0 items"));
    }

    @Test
    public void searchParticularItemTest() {
        LandingPage landingPage = new LandingPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);

        landingPage.searchItem("Beyerdynamic DT 770 Pro 80 Ohm Studio Reference Closed-Back Headphones");
        Assert.assertTrue(productListPage.getItemsTitles().get(0).contains("Beyerdynamic DT 770 Pro 80 Ohm Studio Reference Closed-Back Headphones"));
        Assert.assertTrue(productListPage.getItemListSize() == 1);
    }
}

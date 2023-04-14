package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;
import utils.DriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.newegg.com/");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.acceptCookies();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

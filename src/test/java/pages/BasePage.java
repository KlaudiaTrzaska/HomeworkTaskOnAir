package pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected Duration timeout = Duration.ofSeconds(3);
}

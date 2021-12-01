package io.github.tahanima.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This class defines the basic functionalities of a POM class.
 *
 * @author tahanima
 * @since 11/30/2021
 */
public class BasePage {
    private WebDriver driver;

    public void initialize(final WebDriver webdriver) {
        this.driver = webdriver;

        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected String isAt() {
        return driver.getTitle();
    }
}

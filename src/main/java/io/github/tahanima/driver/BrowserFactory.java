package io.github.tahanima.driver;

import static io.github.tahanima.config.ConfigurationManager.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

/**
 * This enum handles the initialization of browser drivers.
 *
 * <p>
 * This project makes use of the chrome driver and the firefox driver currently.
 * So, this enum contains the initialization logic of these browser drivers.
 * </p>
 *
 * @author tahanima
 * @since 11/30/2021
 */
public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver initializeDriver() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(getOptions());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                    configuration().timeout()));
            driver.manage().window().maximize();

            return driver;
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions options = new ChromeOptions();

            options.setAcceptInsecureCerts(true);
            options.setHeadless(configuration().headless());

            return options;
        }
    }, FIREFOX {
        @Override
        public WebDriver initializeDriver() {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver(getOptions());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                    configuration().timeout()));
            driver.manage().window().maximize();

            return driver;
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions options = new FirefoxOptions();

            options.setAcceptInsecureCerts(true);
            options.setHeadless(configuration().headless());

            return options;
        }
    };

    public abstract WebDriver initializeDriver();

    public abstract AbstractDriverOptions<?> getOptions();
}

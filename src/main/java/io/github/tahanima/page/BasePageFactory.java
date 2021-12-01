package io.github.tahanima.page;

import org.openqa.selenium.WebDriver;

/**
 * This class provides an instance of subclass of BasePage.
 *
 * @author tahanima
 * @since 11/30/2021
 */
public final class BasePageFactory {
    private BasePageFactory() { }

    public static <T extends BasePage> T createInstance(final WebDriver driver,
                                                        final Class<T> page) {
        try {
            BasePage instance = page.getDeclaredConstructor().newInstance();

            instance.initialize(driver);
            return (T) page.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Page class instantiation failed.");
    }
}

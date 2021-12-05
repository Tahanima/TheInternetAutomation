package io.github.tahanima.page;

import static io.github.tahanima.config.ConfigurationManager.configuration;
import static io.github.tahanima.util.UrlConstants.CHECKBOXES_URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class captures the relevant UI components and
 * functionalities of Checkboxes web page.
 *
 * @author tahanima
 * @since 12/06/2021
 */
public final class CheckboxesPage extends BasePage {
    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    private WebElement chkCheckbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    private WebElement chkCheckbox2;

    public void goTo() {
        getDriver().get(configuration().baseUrl() + CHECKBOXES_URL);
    }

    public void checkCheckbox1() {
        chkCheckbox1.click();
    }

    public void checkCheckbox2() {
        chkCheckbox2.click();
    }

    public boolean isCheckbox1Checked() {
        return chkCheckbox1.isSelected();
    }

    public boolean isCheckbox2Checked() {
        return chkCheckbox2.isSelected();
    }
}

package io.github.tahanima.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static io.github.tahanima.config.ConfigurationManager.configuration;
import static io.github.tahanima.util.UrlConstants.DROPDOWN_URL;

/**
 * This class captures the relevant UI components and
 * functionalities of Dropdown web page.
 *
 * @author tahanima
 * @since 01/29/2022
 */
public class DropdownPage extends BasePage {
    @FindBy(id = "dropdown")
    private WebElement ddlDropdownList;

    public void goTo() {
        getDriver().get(configuration().baseUrl() + DROPDOWN_URL);
    }

    public void selectFromDropdownList(final String option) {
        Select select = new Select(ddlDropdownList);
        List<WebElement> options = select.getOptions();

        for (WebElement availableOption: options) {
            if (availableOption.getText().equals(option)) {
                availableOption.click();
                break;
            }
        }
    }

    public String getSelectedDropdownOption() {
        Select select = new Select(ddlDropdownList);

        return select.getFirstSelectedOption().getText();
    }
}

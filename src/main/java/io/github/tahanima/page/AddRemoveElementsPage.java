package io.github.tahanima.page;

import static io.github.tahanima.config.ConfigurationManager.configuration;
import static io.github.tahanima.util.UrlConstants.ADD_REMOVE_ELEMENTS_URL;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class captures the relevant UI components and
 * functionalities of Add/Remove Elements web page.
 *
 * @author tahanima
 * @since 12/02/2021
 */
public final class AddRemoveElementsPage extends BasePage {
    @FindBy(xpath = "//div[@id='content']/div/button")
    private WebElement btnAddElement;

    @FindBy(className = "added-manually")
    private List<WebElement> btnDeleteList;

    public void goTo() {
        getDriver().get(configuration().baseUrl() + ADD_REMOVE_ELEMENTS_URL);
    }

    public void addDeleteButton() {
        btnAddElement.click();
    }

    public int countOfDeleteButtons() {
        return btnDeleteList.size();
    }

    public void removeDeleteButton() {
        if (countOfDeleteButtons() > 0) {
            btnDeleteList.get(0).click();
        }
    }
}

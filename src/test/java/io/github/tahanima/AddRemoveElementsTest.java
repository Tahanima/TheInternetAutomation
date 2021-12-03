package io.github.tahanima;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.tahanima.page.AddRemoveElementsPage;
import org.testng.annotations.Test;

/**
 * @author tahanima
 * @since 12/02/2021
 */
public final class AddRemoveElementsTest extends BaseTest {
    private AddRemoveElementsPage addRemoveElementsPage;

    @Override
    public void initialize() {
        addRemoveElementsPage = createInstance(AddRemoveElementsPage.class);

        addRemoveElementsPage.goTo();
    }

    @Test(description = "Clicking 'Add Element' adds a 'Delete' button")
    public void testAddDeleteButton() {
        int initialDeleteButtonCount =
                addRemoveElementsPage.countOfDeleteButtons();

        addRemoveElementsPage.addDeleteButton();

        int finalDeleteButtonCount =
                addRemoveElementsPage.countOfDeleteButtons();

        assertThat(finalDeleteButtonCount)
                .isEqualTo(initialDeleteButtonCount + 1);
    }

    @Test(description = "Clicking 'Delete' button removes one 'Delete' button")
    public void testRemoveDeleteButton() {
        addRemoveElementsPage.addDeleteButton();

        int initialDeleteButtonCount =
                addRemoveElementsPage.countOfDeleteButtons();

        addRemoveElementsPage.removeDeleteButton();

        int finalDeleteButtonCount =
                addRemoveElementsPage.countOfDeleteButtons();

        assertThat(finalDeleteButtonCount)
                .isEqualTo(initialDeleteButtonCount - 1);
    }
}

package io.github.tahanima;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.tahanima.page.CheckboxesPage;
import org.testng.annotations.Test;

/**
 * @author tahanima
 * @since 12/06/2021
 */
public final class CheckboxesTest extends BaseTest {
    private CheckboxesPage checkboxesPage;

    @Override
    public void initialize() {
        checkboxesPage = createInstance(CheckboxesPage.class);

        checkboxesPage.goTo();
    }

    @Test(description = "Clicking unchecked 'checkbox 1' will cause it to be checked")
    public void testToggleCheckbox1Selection() {
        boolean isChecked = checkboxesPage.isCheckbox1Checked();

        checkboxesPage.checkCheckbox1();

        assertThat(isChecked).isNotEqualTo(checkboxesPage.isCheckbox1Checked());
    }

    @Test(description = "Clicking checked 'checkbox 2' will cause it to be unchecked")
    public void testToggleCheckbox2Selection() {
        boolean isChecked = checkboxesPage.isCheckbox2Checked();

        checkboxesPage.checkCheckbox2();

        assertThat(isChecked).isNotEqualTo(checkboxesPage.isCheckbox2Checked());
    }
}

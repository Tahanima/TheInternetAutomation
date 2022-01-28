package io.github.tahanima;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.tahanima.page.DropdownPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author tahanima
 * @since 01/29/2022
 */
public class DropdownTest extends BaseTest {
    private DropdownPage dropdownPage;

    @Override
    public void initialize() {
        dropdownPage = createInstance(DropdownPage.class);

        dropdownPage.goTo();
    }

    @DataProvider(name = "dropdownData")
    public Object[][] dropdownData() {
        return new Object[][] {{"Option 1"}, {"Option 2"}};
    }


    @Test(description = "Selecting a provided option from the dropdown list "
            + "will display the selected value",
            dataProvider = "dropdownData")
    public void testSelectOption1FromDropdownList(final String option) {
        dropdownPage.selectFromDropdownList(option);

        assertThat(dropdownPage.getSelectedDropdownOption()).isEqualTo(option);
    }
}

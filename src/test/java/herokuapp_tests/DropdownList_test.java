package herokuapp_tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DropdownListPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.DROPDOWN_LIST;

/**
 * -Выбрать опцию по индексу и проверить что опция выбрана
 * -Выбрать опцию по имени и проверить что опция выбрана
 */

public class DropdownList_test extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(priority = 4, description = " drop down list test")
    public void test1() {
        new NavigationPage().navigateTo(DROPDOWN_LIST);
        new DropdownListPage()
                .verifyPageTitle("Dropdown List")
                .select(1)
                .verifySelectedValue("Option 1")
                .select("Option 2")
                .verifySelectedValue("Option 2");
    }
}


package herokuapp_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.herokuapp.DynamicLoadingPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.DYNAMIC_LOADING;

public class DynamicLoading_test {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test
    public void dynamicLoading_Test() {
        new NavigationPage()
                .navigateTo(DYNAMIC_LOADING);
        new DynamicLoadingPage()
                .clickOnExample("Example 1")
                .clickOnStart()
                .pageIsLoaded();
    }
}

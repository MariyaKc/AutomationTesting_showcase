package herokuapp_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.InfiniteScrollPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.INFINITE_SCROLL;

public class ScrollPage_test extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(description = "scroll test")
    public void scrollPage_Test() {
        new NavigationPage()
                .navigateTo(INFINITE_SCROLL);
        new InfiniteScrollPage().infiniteScroll(10);
    }
}

package herokuapp_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.MultipleWindowsPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.MULTIPLE_WINDOWS;

/**
 * - Нажать на Click Here
 * - Переключиться на новое окно и проверить текст
 * - Вернуться на главное окно и закрыть новое окно
 * - Проверить что новое окно было закрыто
 */

public class MultipleWindows_test extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(priority = 7, description = "Multiple Windows test")
    public void test1() {
        new NavigationPage()
                .navigateTo(MULTIPLE_WINDOWS);
        new MultipleWindowsPage()
                .clickHere()
                .switchToNewTab()
                .verifyText()
                .returnToHomeTab()
                .verifyNewTabIsClosed();
    }
}

package herokuapp_tests;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DragAndDropPage;
import pageObjects.herokuapp.NavigationPage;
import testNgUtils.Listener;

import java.awt.*;
import java.io.IOException;

import static pageObjects.herokuapp.NavigationItems.DRAG_AND_DROP;

/**
 * Перетянуть А к В и проверить что элементы поменялись местами
 * -Перетянуть В к A и проверить что элементы поменялись местами
 * Подсказка: для перитягивания элементов используйте класс Actions
 */

public class DragAndDropPage_test extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(priority = 2, description = " drag and drop test with js")
    public void test1() throws AWTException, IOException {
        new NavigationPage()
                .navigateTo(DRAG_AND_DROP);
        new DragAndDropPage()
                .FromAToB()
                .verifyChangeA()
                .FromBToA()
                .verifyChangeB();
    }
}
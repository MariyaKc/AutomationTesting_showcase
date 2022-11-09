package herokuapp_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.FramesPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.FRAMES;

public class Frame_test extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(description = "frame test")
    public void frame_Test() {
        new NavigationPage()
                .navigateTo(FRAMES);
        new FramesPage()
                .clickFrameLink("iFrame")
                .switchToFrame()
                .enterText("HELLO WORLD!")
                .unSwitchFrame()
                .clickBoldTxt();
    }
}

package saucedemo_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.FooterPage;
import saucedemo_tests.steps.LoginSteps;
import testNgUtils.Retry;

public class SD_SocialMedia_Test extends BaseTest {

    @BeforeMethod
    public void preconditions(){
        get(LoginSteps.class).login();
    }

    @Test(description = "Test go to Twittter in Footer page", retryAnalyzer = Retry.class)
    public void TwitterTest() {
        get(FooterPage.class)
                .goToTwitter().switchToNewTab().verifyPageTwitter().returnToHomeTab().verifyNewTabIsClosed();
    }

    @Test(description = "Test go to Facebook in Footer page", retryAnalyzer = Retry.class)
    public void FacebookTest() {
        get(FooterPage.class)
                .goToFacebook().switchToNewTab().verifyPageFacebook().returnToHomeTab().verifyNewTabIsClosed();
    }

    @Test(description = "Test go to Linkedin in Footer page", retryAnalyzer = Retry.class)
    public void LinkedinTest() {
        get(FooterPage.class)
                .goToLinkedin().switchToNewTab().verifyPageLinkedin().returnToHomeTab().verifyNewTabIsClosed();
    }
}

package saucedemo_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.HeaderPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;
import saucedemo_tests.steps.LoginSteps;
import saucedemo_tests.steps.ProductStep;

public class SD_Header_Test extends BaseTest {

    @BeforeMethod
    public void preconditions() {
        get(LoginSteps.class).login();
    }

    @Test(description = "Test for verify log out")
    public void logOutTest() {
        get(HeaderPage.class).clickNavigationBtn().clickLogoutBtn();
        get(LoginPage.class).verifyLoginPageIsOpened();
    }

    @Test(description = "Test for verify open about page")
    public void aboutTest() {
        get(HeaderPage.class).clickNavigationBtn().clickAboutBtn().verifyAboutPageUri().returnBack();
        get(ProductPage.class).verifyProductPageIsOpened();
    }

    @Test(description = "Test for verify return to the Product page after click AllItems")
    public void allItemsTest() {
        get(ProductStep.class).addProductByName(properties.getProperty("productName1"));
        get(HeaderPage.class).clickNavigationBtn().clickAllItemsBtn();
        get(ProductPage.class).verifyProductPageIsOpened();
    }

}

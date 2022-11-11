package sausedemoPageFactory_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.saucedemo.*;
import pageFactory.saucedemo.entity.CheckoutBuilder;
import pageFactory.saucedemo.entity.LoginBuilder;
import pageObjects.baseObjects.BaseTest;

public class SD_CheckoutBuilder_Test extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void precondition(){
        loginPage= new LoginPage();
        loginPage.open();
    }

    @Test(description = "Test (Builder Pattern) :: with standard user data {username}, {password}")
    public void checkoutTest(){

        LoginBuilder loginBuilder = new LoginBuilder.Builder()
                .withUsername("standard_user")
                .withPassword("secret_sauce")
                .build();

        loginPage.enterData(loginBuilder).clickLoginBtn();
        new ProductPage()
                .verifyFilterOptions()
                .selectByName("Price (low to high)").VerifySortPriceLowToHigh()
                .addAllProductToBasket();
        new HeaderPage().clickBasketBtn();
        new BasketPage().clickCheckout();

        CheckoutBuilder checkoutBuilder = new CheckoutBuilder.Builder()
                .withFirstName("firstname")
                .withLastName("lastname")
                .withZipCode("12345")
                .build();

        new CheckoutOnePage().enterData(checkoutBuilder).clickContinueBtn();
        new CheckoutTwoPage().clickFinishBtn();
        new CheckoutCompletePage().verifyCheckoutCompletePage();
    }
}


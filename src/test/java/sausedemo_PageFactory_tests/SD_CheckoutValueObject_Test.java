package sausedemo_PageFactory_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.saucedemo.*;
import pageFactory.saucedemo.entity.Checkout_VObject;
import pageFactory.saucedemo.entity.Login_VObject;
import pageObjects.baseObjects.BaseTest;

public class SD_CheckoutValueObject_Test extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void precondition(){
        loginPage= new LoginPage();
        loginPage.open();
    }

    @Test(description = "Test (Value Object) with standard user data {username}, {password}")
    public void CheckoutTest(){

        Login_VObject login_VObject = new Login_VObject(){{
            setUsername("standard_user");
            setPassword("secret_sauce");
        }};

        loginPage.enterData(login_VObject).clickLoginBtn();
        new ProductPage()
                .verifyFilterOptions()
                .selectByName("Name (A to Z)").VerifySortNameAtoZ()
                .addAllProductToBasket();
        new HeaderPage().clickBasketBtn();
        new BasketPage().clickCheckout();

        Checkout_VObject checkout_vObject  = new Checkout_VObject() {{
            setFirstName("FirstName");
            setLastName("lastname");
            setZipCode("12345");
        }};

        new CheckoutOnePage().enterData(checkout_vObject).clickContinueBtn();
        new CheckoutTwoPage().clickFinishBtn();
        new CheckoutCompletePage().verifyCheckoutCompletePage();
    }
}

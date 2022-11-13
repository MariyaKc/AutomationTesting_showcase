package saucedemo_tests;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.ProductPage;
import saucedemo_tests.steps.LoginSteps;

public class SD_Filter_Test extends BaseTest {

    @Test(description = "Sorting of products test")
    public void SortFilterTest() {

        get(LoginSteps.class).login();

        get(ProductPage.class)
                .clickFilterBtn()
                .selectByName("Name (A to Z)").VerifySortNameAtoZ()
                .selectByName("Name (Z to A)").VerifySortNameZtoA()
                .selectByName("Price (low to high)").VerifySortPriceLowToHigh()
                .selectByName("Price (high to low)").VerifySortPriceHighToLow();
    }
}

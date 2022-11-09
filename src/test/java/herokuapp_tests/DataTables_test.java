package herokuapp_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.dataTables.DataTablesPage;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.dataTables.DataTablesPage2;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pageObjects.herokuapp.dataTables.DataTablesItems.*;
import static pageObjects.herokuapp.NavigationItems.DATA_TABLES;

/**
 * Data Tables
 * 1. Реализовать методы по сбору данных из таблиц в формате List или Map
 * 2. Реализовать методы по проверке сортировки колонок
 */
public class DataTables_test extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(priority = 1, description = " data tables test")
    public void test1() {
        new NavigationPage().navigateTo(DATA_TABLES);
        new DataTablesPage()
                .verifySorting(LASTNAME_DESCENDING)
                .verifySorting(LASTNAME_ASCENDING)
                .verifySorting(FIRSTNAME_DESCENDING)
                .verifySorting(FIRSTNAME_ASCENDING)
                .verifySorting(EMAIL_ASCENDING)
                .verifySorting(EMAIL_DESCENDING)
                .verifySorting(WEBSITE_DESCENDING)
                .verifySorting(WEBSITE_ASCENDING)
                .verifySorting(DUE_ASCENDING)
                .verifySorting(DUE_DESCENDING);
    }

    @Test(description = "Data table test with stream ", priority = 2)
    public void sortCurrency_Test() {
        get(NavigationPage.class).open().navigateTo(NavigationItems.DATA_TABLES);
        Map<String, List<String>> mapTableData = get(DataTablesPage2.class).checkTableIsDisplayed().clickTableColumn("Due").getTableData();
        List<Double> currencyData = mapTableData.get("Due").stream().map(currency -> Double.parseDouble(currency.replace("$", ""))).collect(Collectors.toList());

        List<Double> sortedData = currencyData;
        System.out.println(currencyData);
        Collections.sort(sortedData);
        System.out.println(sortedData);
        Assert.assertEquals(currencyData, sortedData);
    }
}



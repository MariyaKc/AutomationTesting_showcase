package herokuapp_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.FileDownloadPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.FILE_DOWNLOAD;

/**
 * File Download (с зорачкай)
 * Изучить https://www.swtestacademy.com/download-file-in-selenium/
 * Скачать файл
 * Проверить наличие файла на файловой системе
 */

public class FileDownload_test extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(priority = 1, description = " File download test")
    public void test1() throws InterruptedException {
        new NavigationPage()
                .navigateTo(FILE_DOWNLOAD);
        new FileDownloadPage()
                .downloadElementByIndex(2)
                .verifyLastFileInDirectory();
    }
}

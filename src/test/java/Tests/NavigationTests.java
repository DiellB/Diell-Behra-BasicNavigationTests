package Tests;


import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void TestChrome(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com/");
        String title1 = driver.getTitle();
        driver.get("https://etsy.com/");
        String title2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title1, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());
        driver.close();

    }
//    public static void EdgeTest(){
//        WebDriver driver = BrowserFactory.getDriver("edge");
//        driver.get("https://google.com/");
//        String title1 = driver.getTitle();
//        driver.get("https://etsy.com/");
//        String title2 = driver.getTitle();
//        driver.navigate().back();
//        StringUtility.verifyEquals(title1, driver.getTitle());
//        driver.navigate().forward();
//        StringUtility.verifyEquals(title2, driver.getTitle());
//        driver.close();
//
//    }

    public static void FirefoxTest(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com/");
        String title1 = driver.getTitle();
        driver.get("https://etsy.com/");
        String title2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title1, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());
        driver.close();

    }


    public static void main(String[] args) {
        TestChrome();
    //    EdgeTest();
        FirefoxTest();
    }
}
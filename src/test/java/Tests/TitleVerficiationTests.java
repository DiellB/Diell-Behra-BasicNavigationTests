package Tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerficiationTests {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        //TODO VERIFY URL
        String expectedUrl = "http://practice.cybertekschool.com/";
        for (String url:urls) {
            driver.get(url);
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.startsWith(expectedUrl)){
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("actualUrl = " + actualUrl);
                System.out.println("expectedUrl = " + expectedUrl);
            }

        }


//
//        //Test Case - Homework 1
//        driver.get("https://www.google.com/");
//
//        String actualTitle1 = driver.getTitle();
//        String expectedTitle1 = "https://www.google.com/";
//
//        driver.get("https://www.etsy.com");
//
//        String actualTitle2 = driver.getTitle();
//        String expectedTitle2 = "https://www.etsy.com";
//
//        driver.navigate().back();
//        verifyEquals(actualTitle1,expectedTitle1);
//        driver.navigate().forward();
//        verifyEquals(actualTitle2,expectedTitle2);
//

    }
//    private static void verifyEquals (String expectedTitle, String actualTitle){
//        if (expectedTitle.equals(actualTitle)){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//            System.out.println("actualTitle = "+ actualTitle);
//            System.out.println("expectedTitle = + expectedTitle");
//        }
//    }

    }


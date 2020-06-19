package Tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Locators {
    public static void TestingAmazon (){
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.click();
        String SearchPattern  = "macbook";
        searchBox.sendKeys(SearchPattern + Keys.ENTER);
        if (driver.getTitle().toUpperCase().contains(SearchPattern.toUpperCase())){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
        driver.close();
    }

    public static void TestingWikipedia(){
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://wikipedia.com");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.click();
        searchBox.sendKeys("selenium webdriver"+Keys.ENTER);
        driver.findElement(By.linkText("Selenium (software)")).click();
        if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    driver.close();
    }

    public static void TestingGoogle (){
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );
        WebElement element = driver.findElement(By.name("q"));

        for(int i = 0; i < searchStrs.size(); i++){
            element = driver.findElement(By.name("q"));
            element.click();
            element.clear();
            element.sendKeys(searchStrs.get(i) + Keys.ENTER);
            String name = driver.findElement(By.xpath("//cite[1]")).getText();
            name = "https://" + name + "/";
            driver.findElement(By.xpath("(//div[@class='rc']/div/a )[1]")).click();
            StringUtility.verifyEquals(name, driver.getCurrentUrl());
            driver.navigate().back();

        }
        driver.close();
    }

    public static void TestingEbay (){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        WebElement element = driver.findElement(By.id("gh-ac"));
        element.click();
        element.sendKeys("wooden spoon" + Keys.ENTER);
        String resultsNum = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]")).getText();
        resultsNum = resultsNum.replace("," , "");
        driver.findElement(By.xpath("//*[@id=\"x-refine__group__0\"]/ul/li/a/span")).click();
        String resultsNum2 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]")).getText();
        resultsNum2 = resultsNum2.replace(",","");

        int firstRes = Integer.parseInt(resultsNum);
        int secondRes = Integer.parseInt(resultsNum2);

        if(secondRes > firstRes){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.navigate().back();
        String SearchBoxTxt = driver.findElement(By.id("gh-ac")).getAttribute("value");
        StringUtility.verifyEquals(SearchBoxTxt, "wooden spoon");
        driver.navigate().back();

        String SearchBoxHome = driver.findElement(By.id("gh-ac")).getAttribute("value");
        StringUtility.verifyEquals(SearchBoxHome, "");
        driver.close();

    }

    public static void TestingVytrackTitle() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        String username = "user1";
        String password = "UserUser123";
        String firstname = "John";
        String lastname = "Doe";
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();

        WebElement profile = driver.findElement(By.className("dropdown-toggle"));
        Thread.sleep(3000);
        profile.click();
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[1]/a")).click();

        Thread.sleep(5000);
        if(driver.getTitle().startsWith(profile.getText())){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.close();
    }
    public static void TestingVytrackShortcut () throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        String username2 = "salesmanager102";
        String password2 = "UserUser123";
        driver.findElement(By.id("prependedInput")).sendKeys(username2);
        driver.findElement(By.id("prependedInput2")).sendKeys(password2);
        driver.findElement(By.id("_submit")).click();

        String expectedTitle = "Dashboard";
        if(driver.getTitle().equals(expectedTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        WebElement shortcutButton = driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a"));
        Thread.sleep(10000);
        shortcutButton.click();
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[4]/td[1]/a")).click();
        Thread.sleep(10000);
        String currentTitle = "Accounts By Opportunities";
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        Thread.sleep(10000);
        //String errorMsg = "You do not have permission to perform this action.";
        if(driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div")).getText().contains("You do not have permission to perform this action.")){
            System.out.println("PASS - Error message is correct");
        }else{
            System.out.println("Wrong Error Message");
        }

//        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[17]/td[1]/a")).click();
//        String actualMsg = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div")).getText();
//
//        if(actualMsg.equals(errorMsg)){
//            System.out.println("Pass");
//        }else{
//            System.out.println("Fail");
//        }
        String pageTitle = driver.getTitle();
        String Title = "Shortcut Actions List";
        if(pageTitle.equals(Title)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.close();
    }

//    public static void TestingVytrackShortcut () throws InterruptedException {
//        WebDriver driver = BrowserFactory.getDriver("chrome");
//        driver.get("https://app.vytrack.com/user/login");
//        String username2 = "salesmanager102";
//        String password2 = "UserUser123";
//        driver.findElement(By.id("prependedInput")).sendKeys(username2);
//        driver.findElement(By.id("prependedInput2")).sendKeys(password2);
//        driver.findElement(By.id("_submit")).click();
//
//        String expectedTitle = "Dashboard";
//        if(driver.getTitle().equals(expectedTitle)){
//            System.out.println("Pass");
//        }else{
//            System.out.println("Fail");
//        }
//        WebElement shortcutButton = driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a"));
//        Thread.sleep(10000);
//        shortcutButton.click();
//        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[4]/td[1]/a")).click();
//        Thread.sleep(10000);
//        String currentTitle = "Accounts By Opportunities";
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
//        Thread.sleep(10000);
//        //String errorMsg = "You do not have permission to perform this action.";
//        if(driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div")).getText().contains("You do not have permission to perform this action.")){
//            System.out.println("PASS - Error message is correct");
//        }else{
//            System.out.println("Wrong Error Message");
//        }

//        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[17]/td[1]/a")).click();
//        String actualMsg = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div")).getText();
//
//        if(actualMsg.equals(errorMsg)){
//            System.out.println("Pass");
//        }else{
//            System.out.println("Fail");
//        }
//        String pageTitle = driver.getTitle();
//        String Title = "Shortcut Actions List";
//        if(pageTitle.equals(Title)){
//            System.out.println("Pass");
//        }else{
//            System.out.println("Fail");
//        }
//        driver.close();
//    }


    public static void main (String[] args) throws InterruptedException {
        //TestingAmazon();
        //TestingWikipedia();
        //TestingGoogle();
        //TestingEbay();
        //TestingVytrackTitle();
        TestingVytrackShortcut();
    }

}

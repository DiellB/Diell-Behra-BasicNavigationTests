package Tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverWebsitePractice {

    WebDriver driver = BrowserFactory.getDriver("chrome");

    public class TestSuiteSetup {
        @BeforeSuite(alwaysRun = true)
                public void setupSuite(){
            driver.get("https://practice-cybertekschool.herokuapp.com");
        }
    }


    @Test
    public void TestCase1(){

        WebElement clickLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        clickLink.click();
        WebElement inputText = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input"));
        inputText.sendKeys("wrong_dob");
        String verifyText = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();
        //boolean verifyText = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).isDisplayed();
        System.out.println(verifyText);
    }

    @Test
    public void TestCase2(){
        //driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement clickLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        clickLink.click();
        String cLang = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[1]/label")).getText();
        StringUtility.verifyEquals(cLang, "C++");
        String javaLang = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[2]/label")).getText();
        StringUtility.verifyEquals(javaLang, "Java");
        String javascriptLang = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[3]/label")).getText();
        StringUtility.verifyEquals(javascriptLang, "JavaScript");
    }

    @Test
    public void TestCase3(){
        WebElement clickLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        clickLink.click();
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("D");
        String actualWarningMsg = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]")).getText();
        String expectedMsg = "first name must be more than 2 and less than 64 characters long";
        StringUtility.verifyEquals(actualWarningMsg, expectedMsg);
    }

    @Test
    public void TestCase4(){
        WebElement clickLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        clickLink.click();
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("B");
        String actualWarningMsg = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]")).getText();
        String expectedMsg = "The last name must be more than 2 and less than 64 characters long";
        StringUtility.verifyEquals(actualWarningMsg, expectedMsg);
    }

    @Test
    public void TestCase5(){
        WebElement clickLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        clickLink.click();
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("DB");
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("BD");
        WebElement userName = driver.findElement(By.cssSelector("input[name='username']"));
        userName.sendKeys("diellb");
        WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
        email.sendKeys("diell@cybertekschool.com");
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("12345678");
        WebElement phoneNum = driver.findElement(By.cssSelector("input[name='phone']"));
        phoneNum.sendKeys("571-999-2122");
        WebElement gender = driver.findElement(By.cssSelector("input[name='gender']"));
        gender.click();
        WebElement dateBirth = driver.findElement(By.cssSelector("input[name='birthday']"));
        dateBirth.sendKeys("06/16/1994");
        WebElement department = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[9]/div/select"));
        department.click();
        WebElement departmentPick = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[9]/div/select/option[2]"));
        departmentPick.click();
        WebElement jobTitle = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[10]/div/select"));
        jobTitle.click();
        WebElement jobTitlePick = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[10]/div/select/option[5]"));
        jobTitlePick.click();
        WebElement programmingLang = driver.findElement(By.id("inlineCheckbox2"));
        programmingLang.click();
        WebElement programmingLang2 = driver.findElement(By.id("inlineCheckbox3"));
        programmingLang2.click();
        WebElement signUpButton = driver.findElement(By.id("wooden_spoon"));
        signUpButton.click();
        String successMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/p")).getText();
        String expectedMsg = "You've successfully completed registration!";
        StringUtility.verifyEquals(successMsg,expectedMsg);

    }
    @Test
    public void TestCase9 (){
        WebElement clickLink = driver.findElement(By.xpath("//a[@href='/status_codes']"));
        clickLink.click();

        WebElement clickStatus200 = driver.findElement(By.xpath("//a[@href=\"status_codes/200\"]"));
        clickStatus200.click();

        String actualMsg = driver.findElement(By.cssSelector("div.example p")).getText().substring(0,37);
        String expectedMsg = "This page returned a 200 status code.";
        StringUtility.verifyEquals(actualMsg, expectedMsg);
    }
    @Test
    public void TestCase10(){
        WebElement clickLink = driver.findElement(By.xpath("//a[@href='/status_codes']"));
        clickLink.click();
        WebElement clickStatus301 = driver.findElement(By.xpath("//a[@href=\"status_codes/301\"]"));
        clickStatus301.click();
        String actualMsg = driver.findElement(By.cssSelector("div.example p")).getText().substring(0,37);
        String expectedMsg = "This page returned a 301 status code.";
        StringUtility.verifyEquals(actualMsg, expectedMsg);

    }
    @Test
    public void TestCase11(){
        WebElement clickLink = driver.findElement(By.xpath("//a[@href='/status_codes']"));
        clickLink.click();
        WebElement clickStatus404 = driver.findElement(By.xpath("//a[@href=\"status_codes/404\"]"));
        clickStatus404.click();
        String actualMsg = driver.findElement(By.cssSelector("div.example p")).getText().substring(0,37);
        String expectedMsg = "This page returned a 404 status code.";
        StringUtility.verifyEquals(actualMsg, expectedMsg);
    }
    @Test
    public void TestCase12(){
        WebElement clickLink = driver.findElement(By.xpath("//a[@href='/status_codes']"));
        clickLink.click();
        WebElement clickStatus500 = driver.findElement(By.xpath("//a[@href=\"status_codes/500\"]"));
        clickStatus500.click();
        String actualMsg = driver.findElement(By.cssSelector("div.example p")).getText().substring(0,37);
        String expectedMsg = "This page returned a 500 status code.";
        StringUtility.verifyEquals(actualMsg, expectedMsg);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}

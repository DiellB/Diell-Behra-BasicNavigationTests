package Tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverWebsitePracticeTestCases6to9 {
    WebDriver driver = BrowserFactory.getDriver("chrome");

    @Test
    public void testCase6 () {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement signUpLink = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a"));
        signUpLink.click();
        WebElement fullName = driver.findElement(By.cssSelector("input[name='full_name']"));
        //By.xpath("//*[@id=\"login\"]/div[1]/div/input"));
        fullName.sendKeys("John");
        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        emailInput.sendKeys(email);
        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();
        String signUpMsg = driver.findElement(By.name("signup_message")).getText();
        String expectedMsg = "Thank you for signing up. Click the button below to return to the home page.";
        //Assert.assertEquals(signUpMsg, expectedMsg);
        StringUtility.verifyEquals(signUpMsg, expectedMsg);
        driver.navigate().back();
        driver.get("https://www.tempmailaddress.com/");

    }

    @Test
    public void testCase7 () {

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement clickLink = driver.findElement(By.xpath("//a[@href='/upload']"));
        clickLink.click();

        WebElement clickChooseFileButton = driver.findElement(By.id("file-upload"));
        clickChooseFileButton.sendKeys("/Users/bok/Desktop/test.txt.docx");

        WebElement clickUpload = driver.findElement(By.id("file-submit"));
        clickUpload.click();

        String checkMsg = driver.findElement(By.cssSelector("#content > div > h3")).getText();
        String actualMsg = "File Uploaded!";
        StringUtility.verifyEquals(actualMsg, checkMsg);
    }
    @Test
    public void testCase8 () {

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        WebElement clickLink = driver.findElement(By.xpath("//a[@href='/autocomplete']"));
        clickLink.click();

        WebElement typeIntoBox = driver.findElement(By.id("myCountry"));
        typeIntoBox.sendKeys("United States of America");

        WebElement clickSubmitButton = driver.findElement(By.cssSelector("#content > div > form > input"));
        clickSubmitButton.click();

        String verifyMsg = driver.findElement(By.id("result")).getText();
        String actualMsg = "You selected: United States of America";
        StringUtility.verifyEquals(actualMsg, verifyMsg);




//        String popElement = driver.findElement(By.xpath("/tr/td[1]/text()")).getText();
//        String popElementExp = "do-not-reply@practice.cybertekschool.com";
//        Assert.assertEquals(popElement, popElementExp);
        //StringUtility.verifyEquals(popElement, popElementExp );
        //String divText = popElement.findElement(By.className("hidden-xs hidden-sm klikaciRadek newMail")).getAttribute("odMobil");
        //System.out.println(divText.toString());

        //String emailReceived = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]")).getText();

                // xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]")).getText();
        //String emailOfReciever = "do-not-reply@practice.cybertekschool.com";
        //Assert.assertEquals(emailReceived, emailOfReciever);
       //WebElement clickEmail = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]"));
       //clickEmail.click();

       //WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[3]/td[1]/span[2]"));
       //emailAddress.click();
       //String expectedEmailFrom = "do-not-reply@practice.cybertekschool.com";
       //String emailfrom = driver.findElement(By.id("odesilatel")).getText();
       //String emailrec = driver.findElement(By.xpath("//span[@class='popisekMailu' and @id='podesilatel']")).getText();
        //String emailFrom = driver.findElement(By.xpath("/*[@id=\\\"schranka\\\"]/tr[3]/td[1]/span[2]")).getText();
       //Thread.sleep(10000);
       //StringUtility.verifyEquals(emailAddress, expectedEmailFrom);

    }
}

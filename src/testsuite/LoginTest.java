/**
 *2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password is invalid!”
 *
 */


package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "http://the-internet.herokuapp.com/login"; // set base url

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        String expected = "Secure Area";
        String actual = driver.findElement(By.xpath("//div[@class = 'example']//h2[text() = ' Secure Area']")).getText();
        Assert.assertEquals("Correct Message not Displayed",expected,actual);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("xxxx");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        String expected = "Your username is invalid!\n" + "×";
        String actual = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText();
        Assert.assertEquals("Correct Message not Displayed",expected,actual);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("xxxx");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        String expected = "Your password is invalid!\n" + "×";
        String actual = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText();
        Assert.assertEquals("Correct Message not Displayed",expected,actual);
    }

    @After
    public void tearDown(){closeBrowser();}
}

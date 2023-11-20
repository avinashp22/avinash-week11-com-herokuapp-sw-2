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
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        String expected = "Secure Area";
        String actual = driver.findElement(By.xpath("//div[@class = 'example']//h2[text() = ' Secure Area']")).getText();
        Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown(){closeBrowser();}
}

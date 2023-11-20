/**
 *1. Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.
 */


package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    static String browser = "Chrome"; // choose browser
    public static WebDriver driver; // declare globally make public so can inherit

    public void openBrowser(String baseURL)
    {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        driver.get(baseURL);  // get base url
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //give implicit wait to driver
    }
    public static void closeBrowser() {driver.quit();}
}

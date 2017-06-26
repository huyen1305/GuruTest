import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by thanh huyền on 26-Jun-17.
 */
public class Login {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void loginSuccess() {
        driver.get("http://www.demo.guru99.com/v4/");
        driver.findElement(By.name("uid")).sendKeys("mngr84575");
        driver.findElement(By.name("password")).sendKeys("agUvUjA");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Test
    public void loginFailure() {
        driver.get("http://www.demo.guru99.com/v4/");
        driver.findElement(By.name("uid")).sendKeys("mngr84hh");
        driver.findElement(By.name("password")).sendKeys("agUvUjA");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @AfterClass
    public static void cleanUp() {
        if (driver != null) {
            //close browser
            driver.close();
        }
    }
}

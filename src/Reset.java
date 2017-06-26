import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by thanh huyền on 26-Jun-17.
 */
public class Reset {
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.demo.guru99.com/v4/");
    }
    @Test
    public void reset() {
        driver.findElement(By.name("uid")).sendKeys("mngr84hh");
        driver.findElement(By.name("password")).sendKeys("agUvUjA");
        driver.findElement(By.xpath("//input[@type='reset']")).click();
    }
    @AfterClass
    public static void cleanUp() {
        if (driver != null) {
            //close browser
            driver.close();
        }
    }
}

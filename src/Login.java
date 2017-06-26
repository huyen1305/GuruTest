import org.junit.AfterClass;
import org.junit.Assert;
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
    public void loginSuccess() throws InterruptedException {
        driver.get("http://www.demo.guru99.com/v4/");
        driver.findElement(By.name("uid")).sendKeys("mngr84575");
        driver.findElement(By.name("password")).sendKeys("agUvUjA");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(5000);
        String text = " Guru99 Bank Manager HomePage ";
        try {
            Assert.assertEquals(driver.findElement(By.tagName("title")).getAttribute("innerText"),text);
            System.out.println("pass");
        }
        catch (Exception e) {
            System.out.println("fail");
        }
    }
    @Test
    public void loginFailure() {
        driver.get("http://www.demo.guru99.com/v4/");
        driver.findElement(By.name("uid")).sendKeys("mngr84hh");
        driver.findElement(By.name("password")).sendKeys("agUvUjA");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        try {
            Assert.assertEquals(driver.switchTo().alert().getText(),"User or Password is not valid");
            System.out.println("pass");
        }
        catch (Exception e) {
            System.out.println("fail");
        }
    }
    @AfterClass
    public static void cleanUp() {
        if (driver != null) {
            //close browser
            driver.close();
        }
    }
}

package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void OpenBrowser(){
        System.setProperty("webdriver.gecko.driver","/home/faroukn/Downloads/geckodriver");
        System.out.println("Its run ******************");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //login = new LoginPage();
        driver.get("https://demo.nopcommerce.com/");
    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

public class P02_login {

    public WebElement loginlink() {
        return Hooks.driver.findElement(By.className("ico-login"));
    }

    public WebElement emailEle() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement passwordEle() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement logBtn()
    {
        return Hooks.driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
    }

    public WebElement success_msg()
    {
        return Hooks.driver.findElement(By.className("ico-account"));
    }

    public WebElement error_msg()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
    }

}

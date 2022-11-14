package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

public class P03_reset {

    public WebElement resetlink()
    {
        // go to login page
        Hooks.driver.findElement(By.className("ico-login")).click();
        return Hooks.driver.findElement(By.xpath("//span[@class=\"forgot-password\"]"));
    }

    public WebElement emailEle()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement resBtn()
    {
        return Hooks.driver.findElement(By.name("send-email"));
    }

    public WebElement resmsg()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]"));
    }

    public WebElement errmsg()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification error\"]"));
    }

}

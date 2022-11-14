package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepDefs.Hooks;

public class P01_register {

    public WebElement registerlink() {
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement genderEle() {
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement fnameEle() {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lnameEle() {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public Select daySelect()
    {
        Select dayselc = new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        return dayselc;
    }

    public Select monthSelect()
    {
        Select monthselc = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        return monthselc;
    }

    public Select yearSelect()
    {
        Select yearselc = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        return yearselc;
    }

    public WebElement emailEle() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement passwordEle() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmpassEle() {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement regBtn()
    {
        return Hooks.driver.findElement(By.xpath("//button[@id=\"register-button\"]"));
    }

    public WebElement success_msg()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]"));
    }
}

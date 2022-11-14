package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.P02_login;
import pages.P04_homePage;

import java.util.concurrent.ThreadLocalRandom;

public class D07_colorStepDef {
    P02_login login = new P02_login();
    P04_homePage homepage = new P04_homePage();

    @When("^user login with \"(.*)\" and \"(.*)\" then select item$")
    public void user_enter_data(String email,String password)
    {
        login.loginlink().click();
        login.emailEle().sendKeys(email);
        login.passwordEle().sendKeys(password);
        login.logBtn().click();
        Hooks.driver.get("https://demo.nopcommerce.com/shoes"); //user select item
    }

    @Then("user click on specific color")
    public void choose_color()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
        WebElement color_box = homepage.color_chooser().get(randomNum);
        color_box.click();
    }
}

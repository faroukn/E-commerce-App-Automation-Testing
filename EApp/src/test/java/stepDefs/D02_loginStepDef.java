package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import pages.P02_login;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void user_go_to_login_page()
    {
        login.loginlink().click();
    }
    
    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void user_enter_data(String type,String email,String password)
    {
        login.emailEle().sendKeys(email);
        login.passwordEle().sendKeys(password);
    }

    @And("user press on login button")
    public void finally_user_click()
    {
        login.logBtn().click();
    }

    @Then("user login to the system successfully")
    public void success_login()
    {
        SoftAssert soft = new SoftAssert();

        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        soft.assertTrue(login.success_msg().isDisplayed(),"Error in My Account");
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void error_login()
    {
        SoftAssert soft = new SoftAssert();

        String errormsg = login.error_msg().getText();
        soft.assertTrue(errormsg.contains("Login was unsuccessful"),"Error in invalid login");

        soft.assertEquals(Color.fromString(login.error_msg().getCssValue("color")).asHex(),"#e4434b","Error in msg color");

        soft.assertAll();
    }
}

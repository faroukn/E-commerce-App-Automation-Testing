package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.P01_register;

public class D01_registerStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void user_go_to_register_page() {
        //System.out.println("This is a test before start coding");
        register.registerlink().click();
    }

    @When("user select gender type")
    public void user_select_gender_type()
    {
        register.genderEle().click();
    }

    @When("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enterNames(String f_name,String l_name)
    {
        register.fnameEle().sendKeys(f_name);
        register.lnameEle().sendKeys(l_name);
    }

    @When("user enter date of birth")
    public void user_enter_date_of_birth(){

        // enter day of birth
        register.daySelect().selectByIndex(6);

        // enter month of birth
        register.monthSelect().selectByIndex(6);

        // enter year of birth
        register.yearSelect().selectByVisibleText("2003");
    }

    @When("^user enter email \"(.*)\" field$")
    public void user_enter_email(String email)
    {
        register.emailEle().sendKeys(email);
    }

    @When("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void enter_password(String password,String confirmpassword)
    {
        register.passwordEle().sendKeys(password);
        register.confirmpassEle().sendKeys(confirmpassword);
    }

    @When("user clicks on register button")
    public void finally_user_click()
    {
        register.regBtn().click();
    }

    @Then("success message is displayed")
    public void check_message()
    {
        SoftAssert soft = new SoftAssert();

        // check text msg
        String msg = register.success_msg().getText();
        soft.assertEquals(msg,"Your registration completed","Error in success message");

        // check color
        String msg_color = register.success_msg().getCssValue("color");
        soft.assertEquals(msg_color,"rgba(76, 177, 124, 1)","Error in color of success message");

        soft.assertAll();
    }
}
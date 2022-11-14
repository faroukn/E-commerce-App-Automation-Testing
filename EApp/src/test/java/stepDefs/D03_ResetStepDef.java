package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.P03_reset;

public class D03_ResetStepDef {
    P03_reset reset = new P03_reset();

    @Given("user go to reset password page")
    public void user_go_to_reset()
    {
        reset.resetlink().click();
    }

    @When("^user enter \"(.*)\" \"(.*)\"$")
    public void enter_data(String type,String email)
    {
        reset.emailEle().sendKeys(email);
    }

    @And("user clicks on recover button")
    public void finally_user_click()
    {
        reset.resBtn().click();
    }

    @Then("reset message display")
    public void check_success_msg()
    {
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(reset.resmsg().isDisplayed(),"Error in reset msg");
        soft.assertAll();
    }

    @Then("error message display")
    public void check_error_msg()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(reset.errmsg().isDisplayed(),"Error in error msg");
    }
}

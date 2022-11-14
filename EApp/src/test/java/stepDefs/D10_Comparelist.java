package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import pages.P02_login;
import pages.P04_homePage;

public class D10_Comparelist {

    P02_login login = new P02_login();
    P04_homePage homepage = new P04_homePage();

    @Given("^user login with \"(.*)\" and \"(.*)\" then select compare from 4 item$")
    public void user_enter_data(String email,String password) throws InterruptedException {
        login.loginlink().click();
        login.emailEle().sendKeys(email);
        login.passwordEle().sendKeys(password);
        login.logBtn().click();

    }

    @When("user click on add compare for a product")
    public void click_on_shopping()
    {
        homepage.get_home_product_compare().get(2).click();
    }

    @Then("compare message is displayed")
    public void check_msg() throws InterruptedException {
        Thread.sleep(500);
        WebElement msg = homepage.success_msg();
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(msg.isDisplayed(),"Error in shopping msg");

        soft.assertEquals(Color.fromString(msg.getCssValue("background-color")).asHex(),"#4bb07a");

        soft.assertAll();
    }

}

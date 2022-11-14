package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P02_login;
import pages.P04_homePage;

public class D09_Shopping {
    P02_login login = new P02_login();
    P04_homePage homepage = new P04_homePage();

    @Given("^user login with \"(.*)\" and \"(.*)\" then select shopping from 4 item$")
    public void user_enter_data(String email,String password) throws InterruptedException {
        login.loginlink().click();
        login.emailEle().sendKeys(email);
        login.passwordEle().sendKeys(password);
        login.logBtn().click();

    }

    @When("user click on add shopping for a product")
    public void click_on_shopping()
    {
        homepage.get_home_product_shopping().get(2).click();
    }

    @Then("shopping message is displayed")
    public void check_msg() throws InterruptedException {
        Thread.sleep(500);
        WebElement msg = homepage.success_msg();
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(msg.isDisplayed(),"Error in shopping msg");

        soft.assertEquals(Color.fromString(msg.getCssValue("background-color")).asHex(),"#4bb07a");

        soft.assertAll();
    }

    @Then("check number of qty cart")
    public void check_qty()
    {
        WebElement qtyEle = homepage.qtycartEle();
        String qtylist = qtyEle.getText();
        int value = Integer.parseInt(qtylist.replaceAll("[^0-9]", ""));

        Assert.assertTrue(value>0);

    }
}

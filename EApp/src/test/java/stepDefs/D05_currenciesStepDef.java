package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.P02_login;
import pages.P04_homePage;

import java.util.List;

public class D05_currenciesStepDef {

    P02_login login = new P02_login();
    P04_homePage homepage = new P04_homePage();

    @Given("user go to login page then homepage")
    public void user_go_to_login_page()
    {
        login.loginlink().click();
    }

    @When("^user login with \"(.*)\" and \"(.*)\" then homepage$")
    public void user_enter_data(String email,String password)
    {
        login.emailEle().sendKeys(email);
        login.passwordEle().sendKeys(password);
        login.logBtn().click();
    }

    @When("user witch between currencies US-Euro")
    public void switch_currencies()
    {
        homepage.sleect_currencies().selectByIndex(1);
    }

    @Then("4 products have the €")
    public void check_euro()
    {
        List<WebElement> itemlist = homepage.switch_currencies_result();

        for (int i = 0;i < 4;i++){
            WebElement itembox = itemlist.get(i);
            String item_price = itembox.getText();
            System.out.println(item_price);
            Assert.assertTrue(item_price.contains("€"),"Error in results");
        }
    }
}

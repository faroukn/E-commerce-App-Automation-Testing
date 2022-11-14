package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P02_login;
import pages.P04_homePage;

import java.util.List;

public class D04_searchStepDef {

    P02_login login = new P02_login();
    P04_homePage search = new P04_homePage();
    public String kword=null;

    @Given("user go to login page to login")
    public void user_go_to_login_page()
    {
        login.loginlink().click();
    }

    @When("^user login with \"(.*)\" and \"(.*)\" then go to homepage$")
    public void user_enter_data(String email,String password)
    {
        login.emailEle().sendKeys(email);
        login.passwordEle().sendKeys(password);
        login.logBtn().click();
    }

    @When("^user search for ([^\"]*)$")
    public void searchfor(String kword)
    {
        search.searchEle().sendKeys(kword);
        this.kword = kword;
    }

    @And("clicks Enter to search")
    public void finally_user_click()
    {
        search.serchBtn().click();
    }

    @Then("search shows results with word")
    public void check_reults_of_word()
    {
        SoftAssert soft = new SoftAssert();

        String url = Hooks.driver.getCurrentUrl();
        soft.assertTrue(url.contains("https://demo.nopcommerce.com/search?q="),"Error in search url");

        List<WebElement> itemlist = search.search_result();
        int count_items = itemlist.size();

        for (int i = 0;i < count_items;i++){
            WebElement itembox = itemlist.get(i);
            String item_title = itembox.getText().toLowerCase();
            soft.assertTrue(item_title.contains(kword.toLowerCase()),"Error in search results");
        }

        soft.assertAll();

    }

    @Then("clicks on the item")
    public void click_on_item()
    {
        search.search_result().get(0).findElement(By.tagName("a")).click();
    }

    @Then("search shows results with sku")
    public void check_reults_of_sku()
    {
        String actual_sku = search.skuEle().getText();
        Assert.assertEquals(actual_sku,kword,"Error in sku");
    }
}


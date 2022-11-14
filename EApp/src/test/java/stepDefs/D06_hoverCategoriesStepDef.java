package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.P02_login;
import pages.P04_homePage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class D06_hoverCategoriesStepDef {

    P02_login login = new P02_login();
    P04_homePage homepage = new P04_homePage();

    public String title = "";

    @Given("user go to login page to login then hover")
    public void user_go_to_login_page()
    {
        login.loginlink().click();
    }

    @When("^user login with \"(.*)\" and \"(.*)\" then homepage to hover$")
    public void user_enter_data(String email,String password)
    {
        login.emailEle().sendKeys(email);
        login.passwordEle().sendKeys(password);
        login.logBtn().click();
    }

    @When("user select and hover from main menu and user click on sub menu")
    public void hover_main_menu() throws InterruptedException {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
        int subrandomNum = ThreadLocalRandom.current().nextInt(0, 3);
        WebElement mainMenu = homepage.main_menu().get(randomNum);
        List<WebElement> subMenu = mainMenu.findElement(By.tagName("ul")).findElements(By.tagName("li"));
        this.title = subMenu.get(subrandomNum).getText();
        Actions actions = new Actions(Hooks.driver);

        actions.moveToElement(mainMenu);
        Thread.sleep(2000);
        actions.moveToElement(subMenu.get(subrandomNum));
        Thread.sleep(2000);
        actions.click().build().perform();
        Thread.sleep(2000);

    }

    @Then("Assert that the sub-category title is the one you get it while selecting random sub-category")
    public void assert_and_check() throws InterruptedException {
        Thread.sleep(3000);
        String[] tt = Hooks.driver.getCurrentUrl().split("/");
        String title_page = Hooks.driver.findElement(By.tagName("h1")).getText();
        System.out.println(title.toLowerCase().trim());
        System.out.println(tt[3]);
        Assert.assertEquals(tt[3],title.toLowerCase().trim(),"error in title");
    }
}

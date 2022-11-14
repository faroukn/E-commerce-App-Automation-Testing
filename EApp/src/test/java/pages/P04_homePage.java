package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepDefs.Hooks;

import java.util.List;

public class P04_homePage {

    public WebElement searchEle()
    {
        return Hooks.driver.findElement(By.name("q"));
    }

    public WebElement serchBtn()
    {
        return  Hooks.driver.findElement(By.xpath("//button[@class=\"button-1 search-box-button\"]"));
    }
    public List<WebElement> search_result()
    {
        List<WebElement> itemlist = Hooks.driver.findElements(By.className("product-title"));
        return itemlist;
    }

    public WebElement skuEle()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"sku\"]/span[@class=\"value\"]"));
    }

    public Select sleect_currencies()
    {
        return new Select(Hooks.driver.findElement(By.id("customerCurrency")));
    }

    public List<WebElement> switch_currencies_result()
    {
        List<WebElement> itemlist = Hooks.driver.findElements(By.xpath("//span[@class=\"price actual-price\"]"));
        return itemlist;
    }

    public List<WebElement> main_menu()
    {
        List<WebElement> main_elemnts = Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
        return main_elemnts;
    }

    public WebElement title_page()
    {
        return Hooks.driver.findElement(By.className("page-title"));
    }

    public List<WebElement> color_chooser()
    {
        List<WebElement> color_elemnts = Hooks.driver.findElements(By.xpath("//li[@class=\"item color-item\"]"));
        return color_elemnts;
    }

    public List<WebElement> get_home_product_wishlist()
    {
        return Hooks.driver.findElements(By.xpath("//button[@class=\"button-2 add-to-wishlist-button\"]"));
    }

    public WebElement success_msg()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]"));
    }

    public WebElement qtyEle()
    {
        return Hooks.driver.findElement(By.xpath("//span[@class=\"wishlist-qty\"]"));
    }

    public List<WebElement> get_home_product_shopping()
    {
        return Hooks.driver.findElements(By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]"));
    }

    public WebElement qtycartEle()
    {
        return Hooks.driver.findElement(By.xpath("//span[@class=\"cart-qty\"]"));
    }

    public List<WebElement> get_home_product_compare()
    {
        return Hooks.driver.findElements(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]"));
    }



}

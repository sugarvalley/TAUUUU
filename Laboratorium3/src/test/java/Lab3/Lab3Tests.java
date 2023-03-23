package Lab3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class Lab3Tests {
    WebDriver driverChrome;
    WebDriver driverFirefox;
    Map<String, Object> vars;
    JavascriptExecutor jsChrome;
    JavascriptExecutor jsFirefox;
    @Before
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        jsChrome = (JavascriptExecutor) driverChrome;
    }
    @Before
    public void setupGeckoDriver() {
        WebDriverManager.firefoxdriver().setup();
        driverFirefox = new FirefoxDriver();
        jsFirefox = (JavascriptExecutor) driverFirefox;
    }
    @Before
    public void setUp() {
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driverChrome.quit();
        driverFirefox.quit();
    }

    public void loadPage(WebDriver driver,String url){
        driver.get(url);
        driver.manage().window().setSize(new Dimension(945, 1020));
    }

    public void logIn(WebDriver driver,String username,String password){
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    }

    public void addToCart(WebDriver driver,String product){
        driver.findElement(By.cssSelector(product)).click();
    }
    @Test
    public void loadPageTest() {
        driverChrome.get("https://www.saucedemo.com/");
        driverChrome.manage().window().setSize(new Dimension(945, 1020));
        {
            List<WebElement> elements = driverChrome.findElements(By.cssSelector(".login_logo"));
            assert (elements.size() > 0);
        }
        driverChrome.close();
    }
    @Test()
    public void loginTest() {
        loadPage(driverChrome, "https://www.saucedemo.com/");
        logIn(driverChrome,"standard_user","secret_sauce");
        {
            List<WebElement> elements = driverChrome.findElements(By.cssSelector(".app_logo"));
            assert(elements.size() > 0);
        }
        driverChrome.close();
    }
    @Test
    public void cartTest() {
        loadPage(driverChrome, "https://www.saucedemo.com/");
        logIn(driverChrome,"standard_user","secret_sauce");
        addToCart(driverChrome,"*[data-test=\"add-to-cart-sauce-labs-onesie\"]");
        driverChrome.findElement(By.linkText("1")).click();
        assertThat(driverChrome.findElement(By.cssSelector(".inventory_item_name")).getText(), is("Sauce Labs Onesie"));
        driverChrome.close();
    }
}

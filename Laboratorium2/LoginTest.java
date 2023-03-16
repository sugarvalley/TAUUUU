
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static void main(String[] args) {
        // Set the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C://TestFiles//chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Find the username input element and enter a valid username
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        // Find the password input element and enter a valid password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        // Find the login button element and click it
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Wait for the page to load and check that the user is logged in
        WebElement productsTitle = driver.findElement(By.className("product_label"));
        if (productsTitle.isDisplayed()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }

        // Test corner cases

        // 1. Test with a valid username and an invalid password
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("invalid_password");
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Corner case 1 passed: invalid password");
        } else {
            System.out.println("Corner case 1 failed.");
        }

        // 2. Test with an invalid username and a valid password
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys("invalid_username");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Corner case 2 passed: invalid username");
        } else {
            System.out.println("Corner case 2 failed.");
        }

        // 3. Test with an empty username and a valid password
        usernameInput.clear();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Corner case 3 passed: empty username");
        } else {
            System.out.println("Corner case 3 failed.");
        }

        // 4. Test with a valid username and an empty password
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys("standard_user");
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Corner case 4 passed: empty password");
        } else {
            System.out.println("Corner case 4 failed.");
        }

        // 5. Test with a valid username and a password containing only spaces
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("   ");
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Corner case 5 passed: password containing only spaces");
        } else {
            System.out.println("Corner case 5 failed.");
        }
        // 6. Test with an empty username and an empty password
        usernameInput.clear();
        passwordInput.clear();
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Corner case 6 passed: empty username and password");
        } else {
            System.out.println("Corner case 6 failed.");
        }

        // 7. Test with a valid username and password, but with leading/trailing whitespaces
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys(" standard_user ");
        passwordInput.sendKeys(" secret_sauce ");
        loginButton.click();
        if (productsTitle.isDisplayed()) {
            System.out.println("Corner case 7 passed: leading/trailing whitespaces");
        } else {
            System.out.println("Corner case 7 failed.");
        }

        // 8. Test with a valid username and password, but with uppercase letters
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys("STANDARD_USER");
        passwordInput.sendKeys("SECRET_SAUCE");
        loginButton.click();
        if (productsTitle.isDisplayed()) {
            System.out.println("Corner case 8 passed: uppercase letters");
        } else {
            System.out.println("Corner case 8 failed.");
        }
    }
}

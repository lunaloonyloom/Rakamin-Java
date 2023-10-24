package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com/"; //set base url

    @Given("user is on  login page")
    public void user_is_on_login_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //assertion
        driver.findElement(By.className("login-box"));
    }

    @When("user input valid username")
    public void userInputValidUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @When("user input invalid username")
    public void userInputInvalidUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input valid password")
    public void userInputValidPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user input invalid password")
    public void userInputInvalidPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user click Login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("dashboard page displayed")
    public void dashboardPageDisplayed() {
        driver.findElement(By.className("app_logo"));
    }

    @Then("fail message displayed")
    public void failMessageDisplayed() {
        String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
                //.equals(By.name("Epic "))
    }
}

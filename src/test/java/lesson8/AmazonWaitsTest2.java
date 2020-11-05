package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AmazonWaitsTest2 {
    By signInBy = By.id("nav-link-accountList");
    By createAccountBy = By.id("createAccountSubmit");
    By continueBy = By.id("continue");
    By customerNameBy = By.id("ap_customer_name");
    By customerEmailBy = By.id("ap_email");
    By customerPasswordBy = By.id("ap_password");
    By customerPasswordCheckBy = By.id("ap_password_check");
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
       // driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
       // wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(signInBy).click();
        driver.findElement(createAccountBy).click();
        driver.findElement(customerNameBy).click();
        driver.findElement(customerNameBy).sendKeys("oxygen");
        driver.findElement(customerEmailBy).click();
        driver.findElement(customerEmailBy).sendKeys("zorrokasper@gmail.com");
        driver.findElement(customerPasswordBy).click();
        driver.findElement(customerPasswordBy).sendKeys("111111");
        driver.findElement(continueBy).click();

        //перевірка хайлайта поля Repassword
        String passwordCheckExpectedColor = "rgb(221, 0, 0)";
        String passwordCheckActualColor = driver.findElement(customerPasswordCheckBy).getCssValue("border-color;");
        assertEquals(passwordCheckActualColor, passwordCheckExpectedColor);



    }

        @AfterMethod
    public void finilizeBrowser(){
      //  driver.quit();
    }
}

package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchAmazon {
    WebDriver driver;

    public SearchAmazon() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void SearchAmazon() {

        // Navigate to google.com https://www.google.com/
        driver.get("https://www.google.com");
        // Enter amazon in search textfield Using Locator "ID" //textarea[@name="q"] |
        // sendKeys"amazon"
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("amazon");
        // Press "Google Search" button Using Locator "ID" //input[@name='btnK']
        // //input[@name='btnK'] or Use .sendKeys(Keys.RETURN)
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        // Verify that amazon.in OR amazon.com link is present on the page Using Locator
        // "Name" //span[text()='Amazon.in'] or //span[text()='Amazon.com']
        boolean result = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']"))
                .isDisplayed();

        System.out.println("Is amazon present in results? :" + result);
    }
}

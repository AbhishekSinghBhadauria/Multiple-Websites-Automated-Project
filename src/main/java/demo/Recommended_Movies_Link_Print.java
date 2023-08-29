package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class Recommended_Movies_Link_Print {
    WebDriver driver;

    public Recommended_Movies_Link_Print() {
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

    public void Recommended_Movies_Link_Print() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        List<WebElement> allLinks = driver.findElements(
                By.xpath("//img[starts-with(@src, 'https://assets-in.bmscdn.com/discovery-catalog/events/')]"));
        for (int i = 0; i < allLinks.size(); i++) {
            System.out.println("Link:--> " + (allLinks.get(i)).getAttribute("src"));
        }
        String movieName = driver.findElement(By.xpath(
                "//*[@id=\"https://in.bookmyshow.com/chennai/movies/por-thozhil/ET00357691-1\"]/div/div[3]/div[1]/div"))
                .getText();
        System.out.println("Movie name" + movieName);

    }

}
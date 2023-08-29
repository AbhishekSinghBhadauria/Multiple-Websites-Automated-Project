package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Automate_post_on_linkedin {
    WebDriver driver;

    public Automate_post_on_linkedin() {
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

    public void Automate_post_on_linkedin() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.navigate().to("https://www.linkedin.com/");
        Thread.sleep(7000);
        // driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        // List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
        // System.out.println("Total Number of Links " + allLinks.size());
        driver.findElement(By.xpath("//input[@autocomplete = \"username\"]"))
                .sendKeys("abhisheksinghbhadauria1@gmail.com");
        driver.findElement(By.xpath("//input[@autocomplete = \"current-password\"]")).sendKeys("Tyu789vbn_123");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click(); // Click on sign-in
        Thread.sleep(5000);

        // driver.findElement(By.xpath("//*[@id=\"ember1530\"]/div[2]")).click(); // Go
        // to your profile
        // driver.findElement(By.id("ember1550")).click(); // Move to dashboard
        // String postImpression =
        // driver.findElement(By.xpath("//*[@id=\"ember1863\"]/div/div")).getText();
        // String profileViews =
        // driver.findElement(By.xpath("//*[@id=\"ember1865\"]/div/div")).getText();
        // driver.navigate().to("https://www.linkedin.com/feed/");
        driver.findElement(By.xpath("//span[text()='Start a post']")).click(); // Click to start post
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ember2155\"]/div/div[2]/div[1]/div/div/div/div/div/div/div[1]"))
                .sendKeys("This is my first Post"); // Type something you want to share
        driver.findElement(By.xpath("//*[@id=\"share-to-linkedin-modal__header\"]/button")).click(); // Click on the drop down and select connection only
        driver.findElement(By.id("ember2180")).click(); // click to post
        // System.out.println("Post Impression" + postImpression);
        // System.out.println("Profile Views" + profileViews);
        //System.out.println("end Test case: testCase02");
    }

}
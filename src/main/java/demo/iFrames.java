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
import org.openqa.selenium.support.ui.Wait;

public class iFrames {
    WebDriver driver;

    public iFrames() {
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

    public void iFrames() throws InterruptedException {

        // Navigate to the provided link
        // https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Wait for the page to load thread.sleep()
        Thread.sleep(3000);
        // Switch to the top frame Using Locator "CSS Selector"
        // driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-top");
        // Switch to the left frame Using Locator "CSS Selector"
        // driver.switchTo().frame("frame-left");
        driver.switchTo().frame("frame-left");
        // Get text from the left frame Using Locator "Tag Name" String leftFrameText =
        // driver.findElement(By.tagName("body")).getText(); System.out.println("Text
        // from left frame:"); System.out.println(leftFrameText);
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text from left frame:");
        System.out.println(leftFrameText);
        // Switch back to the top frame driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        // Switch to the middle frame driver.switchTo().frame("frame-middle");
        driver.switchTo().frame("frame-middle");
        // Get text from the middle frame Using Locator "Tag Name" String
        // middleFrameText = driver.findElement(By.tagName("body")).getText();
        // System.out.println("Text from middle frame:");
        // System.out.println(middleFrameText);
        String middleFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text from middle frame:");
        System.out.println(middleFrameText);
        // Switch back to the top frame driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        // Switch to the right frame driver.switchTo().frame("frame-right");
        driver.switchTo().frame("frame-right");
        // Get text from the right frame String rightFrameText =
        // driver.findElement(By.tagName("body")).getText(); System.out.println("Text
        // from right frame:"); System.out.println(rightFrameText);
        String rightFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text from right frame:");
        System.out.println(rightFrameText);
        // Switch back to the top frame driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        // Switch to the bottom frame Using Locator "Tag Name"
        // driver.switchTo().frame("frame-bottom");
        driver.switchTo().frame("frame-bottom");
        // Get text from the bottom frame String bottomFrameText =
        // driver.findElement(By.tagName("body")).getText(); System.out.println("Text
        // from bottom frame:"); System.out.println(bottomFrameText);
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text from bottom frame:");
        System.out.println(bottomFrameText);

    }

}

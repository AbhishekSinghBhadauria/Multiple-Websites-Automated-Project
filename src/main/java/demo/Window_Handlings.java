package demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class Window_Handlings {
    ChromeDriver driver;
    public Window_Handlings()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void Window_Handlings() throws IOException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String parentHandle = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[@onclick = \"myFunction()\"]")).click();
        driver.switchTo().defaultContent();
        Set<String> allHandles = driver.getWindowHandles();
        
        String url = ""; String title = "";
        for(String currenthandle : allHandles)
        {
            if(!(parentHandle.equalsIgnoreCase(currenthandle)))
            {
                driver.switchTo().window(currenthandle);
                url = driver.getCurrentUrl();
                title = driver.getTitle();

                String timestamp = String.valueOf(java.time.LocalDateTime.now());
                String filename = String.format("screenshot_%s.png", timestamp).replace(":", "-"); 
                
                TakesScreenshot screenshot = ((TakesScreenshot) driver);
                File srcFile = screenshot.getScreenshotAs(OutputType.FILE); 

                File destFile = new File(filename);
                FileUtils.copyFile(srcFile, destFile);

                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentHandle);
        System.out.println("URL --> " + url + "Title --> " + title);
    
    }


}
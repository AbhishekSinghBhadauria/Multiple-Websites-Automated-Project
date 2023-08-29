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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class Imdb_Ratings {
    ChromeDriver driver;
    public Imdb_Ratings()
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

    
    public  void imdb_Ratings (){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.imdb.com/chart/top");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        WebElement sortBy = driver.findElement(By.xpath("//*[@id=\"lister-sort-by-options\"]"));
        Select dropdown = new Select(sortBy); 
        
        dropdown.selectByVisibleText("Ranking");
        String highestRatedMovie = driver.findElement(By.xpath("//*[@id=\"main\"]/div/span/div[1]/div/div[3]/table/tbody/tr[1]/td[2]")).getText();

        dropdown.selectByVisibleText("Release Date");
        String oldestMovie = driver.findElement(By.xpath("//*[@id=\"main\"]/div/span/div[1]/div/div[3]/table/tbody/tr[250]/td[2]")).getText();
        String newestMovie = driver.findElement(By.xpath("//*[@id=\"main\"]/div/span/div[1]/div/div[3]/table/tbody/tr[1]/td[2]")).getText();

        dropdown.selectByVisibleText("Number of Ratings");
        String userRating = driver.findElement(By.xpath("//*[@id=\"main\"]/div/span/div[1]/div/div[3]/table/tbody/tr[1]/td[2]")).getText();

        int totalMovies = driver.findElements(By.xpath("//*[@id=\"main\"]/div/span/div[1]/div/div[3]/table/tbody/tr/td[2]")).size();

        System.out.println("Highest Rated Movie = " + highestRatedMovie + " Oldest Movie = " + oldestMovie + " Newest Movie = " + newestMovie + " Most User Rating = " + userRating + " Total mvies = " + totalMovies);

    }


}
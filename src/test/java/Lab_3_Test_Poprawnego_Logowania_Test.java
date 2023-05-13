import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Lab_3_Test_Poprawnego_Logowania_Test {

    @Test
    public void correctLoginTest(){

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(new Config().getApplicationUrl());

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("test@test.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("Test1!");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        WebElement welcomeElm = driver.findElement(By.cssSelector(".profile_info>h2"));

        Assert.assertTrue(welcomeElm.isDisplayed());
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"));

        driver.quit();



    }

}

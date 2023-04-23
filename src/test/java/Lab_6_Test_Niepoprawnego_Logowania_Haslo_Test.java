import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab_6_Test_Niepoprawnego_Logowania_Haslo_Test {

        @Test
        public void incorrectLoginTestWrongPassword() {

            System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get("http://localhost:4444/");

            WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
            emailTxt.sendKeys("test@test.com");

            WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
            passwordTxt.sendKeys("Test123!");

            WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
            loginBtn.click();

            List<WebElement> validationErrors = driver.findElements(By.cssSelector(".validation-summary-errors>ul>li"));
            boolean doesErrorExists = validationErrors
                    .stream()
                    .anyMatch(validationError -> validationError.getText().equals("Invalid login attempt."));
            Assert.assertTrue(doesErrorExists);


        }
    }


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Lab_9_Test_Niepoprawnego_Logowania_Test_Object_Pattern {
        private WebDriver driver;

        @Test
        public void incorrectLoginTest() {

            System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://localhost:4444/");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.typeEmail("test2@test.com");
            loginPage.typePassword("Test1!");
            loginPage.submitLoginWithFailure();
            loginPage.expectLoginError("Invalid login attempt.");

            driver.quit();
        }
    }

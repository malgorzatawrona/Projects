import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Lab_8_Test_Poprawnego_Logowania_POP_Test {
    private WebDriver driver;

    @Test
    public void correctLoginTest() {

        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:4444/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail("test@test.com");
        loginPage.typePassword("Test1!");
        HomePage homePage = loginPage.submitLogin();


        Assert.assertTrue(homePage.welcomeElm.isDisplayed(), "Welcome element is not shown." );
        Assert.assertTrue(homePage.welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + homePage.welcomeElm.getText() + "' does not contain word 'Welcome'");

        driver.quit();

    }
}

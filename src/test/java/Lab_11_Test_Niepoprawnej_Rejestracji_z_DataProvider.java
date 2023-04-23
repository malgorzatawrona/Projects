import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import java.time.Duration;


public class Lab_11_Test_Niepoprawnej_Rejestracji_z_DataProvider {
    private WebDriver driver;

    @DataProvider
    public Object[][] getWrongEmails(){
        return new Object[][]{
                {"test"},
                {"admin"},
                {"@test"}
        };
    }

    @Test(dataProvider = "getWrongEmails")
    public void incorrectRegister(String wrongEmail){

        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:4444/");

        LoginPage loginPage = new LoginPage(driver);
        CreateAccountPage createAccountPage = loginPage.goToRegisterPage();
        createAccountPage.typeEmail(wrongEmail);
        createAccountPage.typePassword("Test1!");
        createAccountPage.typeConfirmPassword("Test1!");
        createAccountPage.submitRegisterWithFailure();

        Assert.assertEquals(createAccountPage.emailError.getText(), "The Email field is not a valid e-mail address.");

        driver.quit();

    }

}

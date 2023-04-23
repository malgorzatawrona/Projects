import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.time.Duration;

public class Lab_10_Test_Niepoprawnego_Logowania_Email_DataSource_Test {
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
    public void incorrectEmailTest(String wrongEmail) {

        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:4444/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(wrongEmail);
        loginPage.submitLoginWithFailure();

        Assert.assertEquals(loginPage.emailError.getText(), "The Email field is not a valid e-mail address.");

        driver.quit();

    }
}

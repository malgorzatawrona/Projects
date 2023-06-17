import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.pages.LoginPage;

public class RegistrationIncorrectPasswordTest extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getCorrectEmails(){
        return new Object[][]{
                {"test2@next.com"},
        };
    }

    @Test(dataProvider = "getCorrectEmails")
    public void incorrectRegisterWithChaining(String correctEmail)
    {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(correctEmail)
                .typePassword("Test1!")
                .typeConfirmPassword("test!!")
                .submitRegisterWithFailure()
                .checkPasswordsDontMatchAlert();

    }


}

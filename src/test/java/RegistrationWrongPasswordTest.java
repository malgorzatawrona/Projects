import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.pages.LoginPage;

public class RegistrationWrongPasswordTest extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getIncorrectPassword(){
        return new Object[][]{
                {"wiosna12!", "Passwords must have at least one uppercase ('A'-'Z')."},
                {"Wiosna!", "Passwords must have at least one digit ('0'-'9')."},
                {"Wiosna12", "Passwords must have at least one non alphanumeric character."}
        };
    }

    @Test(dataProvider = "getIncorrectPassword")
    public void incorrectRegisterWithChaining(String incorrectPassword, String message)
    {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail("kotek12@kotek.pl")
                .typePassword(incorrectPassword)
                .typeConfirmPassword(incorrectPassword)
                .submitRegisterWithFailure()
                .checkWrongPasswordMessage(message);

    }
}

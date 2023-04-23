import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_10_Test_Niepoprawnego_Logowania_Email_DataSource_Test extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getWrongEmails() {
        return new Object[][]{
                {"test"},
                {"admin"},
                {"@test"}
        };
    }

    @Test(dataProvider = "getWrongEmails")
    public void incorrectEmailTestWithChaining(String wrongEmail) {
        new LoginPage(driver)
                .typeEmail(wrongEmail)
                .submitLoginWithFailure()
                .expectEmailError("The Email field is not a valid e-mail address.");

    }
}

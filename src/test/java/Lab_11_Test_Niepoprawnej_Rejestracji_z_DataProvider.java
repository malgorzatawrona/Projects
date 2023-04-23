
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;


public class Lab_11_Test_Niepoprawnej_Rejestracji_z_DataProvider extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getWrongEmails(){
        return new Object[][]{
                {"test"},
                {"admin"},
                {"@test"}
        };
    }

    @Test(dataProvider = "getWrongEmails")
    public void incorrectRegisterWithChaining(String wrongEmail)
    {
        new LoginPage(driver)
        .goToRegisterPage()
        .typeEmail(wrongEmail)
        .typePassword("Test1!")
        .typeConfirmPassword("Test1!")
        .submitRegisterWithFailure();
    }

}

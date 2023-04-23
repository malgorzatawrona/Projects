import org.testng.annotations.Test;
import pages.LoginPage;

public class  Lab_8_Test_Poprawnego_Logowania_POP_Test extends SeleniumBaseTest {

    @Test
    public void correctLoginTestWithChaining()
    {
        new LoginPage(driver)
            .typeEmail("test@test.com")
            .typePassword("Test1!")
            .submitLogin()
            .assertWelcomeElementIsShown();
    }
}

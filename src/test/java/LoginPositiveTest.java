import org.testng.annotations.Test;
import config.pages.LoginPage;

public class LoginPositiveTest extends SeleniumBaseTest {

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

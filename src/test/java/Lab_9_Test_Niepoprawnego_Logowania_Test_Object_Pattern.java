import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_9_Test_Niepoprawnego_Logowania_Test_Object_Pattern extends SeleniumBaseTest{

        @Test
        public void incorrectLoginTestWithChaining()
        {
            new LoginPage(driver)
            .typeEmail("test2@test.com")
            .typePassword("Test1!")
            .submitLoginWithFailure()
            .expectLoginError("Invalid login attempt.");

        }
    }

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import config.pages.LoginPage;

public class RegistrationPositiveTest extends SeleniumBaseTest{

    @Test
    public void correctRegisterWithChaining()
    {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(email)
                .typePassword("Domek23@")
                .typeConfirmPassword("Domek23@")
                .submitRegister()
                .assertWelcomeElementIsShown();
    }
}

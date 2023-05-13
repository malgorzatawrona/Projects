import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_13_HomePage_Menu_Test extends SeleniumBaseTest {

    @Test
    public void goToProcessesTest() {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses();
    }

    @Test
    public void goToCharacteristicTest() {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToCharacteristic();
    }

    @Test
    public void goToDashboardsTest() {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToDashboards();

    }
}


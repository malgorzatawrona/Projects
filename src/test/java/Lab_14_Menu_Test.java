import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_14_Menu_Test extends SeleniumBaseTest {

    @Test
    public void menuTest(){
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                    .assertProcessesUrl("http://localhost:4444/Projects")
                    .assertProcessesHeader()
                .goToCharacteristic()
                    .assertCharacteristicUrl("http://localhost:4444/Characteristics")
                    .assertCharacteristicsHeader()
                .goToDashboards()
                .assertDashboardUrl("http://localhost:4444/")
                .assertDashboardHeader();

    }

    }



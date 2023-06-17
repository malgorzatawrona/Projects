import org.testng.annotations.Test;
import config.pages.LoginPage;

import java.util.UUID;

public class ProcessCreationTest extends SeleniumBaseTest {

@Test
    public void addProcessTest(){
        String processName = UUID.randomUUID().toString().substring(0,10);

        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                .clickAddNewProcess()
                .typeName(processName)
                .submitCreate()
                .assertProcess(processName,"","");
    }
}

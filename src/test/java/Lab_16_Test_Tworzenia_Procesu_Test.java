import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProcessesPage;

import java.util.UUID;

public class Lab_16_Test_Tworzenia_Procesu_Test extends SeleniumBaseTest {


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
                .submit(Create)
                .assertProcess(processName."","");
}
}

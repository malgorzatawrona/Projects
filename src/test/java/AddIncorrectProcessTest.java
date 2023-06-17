import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.pages.LoginPage;

public class AddIncorrectProcessTest extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getIncorrectProcessName(){
        return new Object[][]{
                {"ws"},
                {"kdjinkmnikijnmikjikmnjikmnjikmnjk"}
        };
    }

    @Test(dataProvider = "getIncorrectProcessName")
    public void addProcessWithFailureTest(String processName){

        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                .clickAddNewProcess()
                .typeName(processName)
                .submitCreateWithFailure()
                .assertProcessNameError()
                .backToList()
                .assertProcessIsNotShown(processName);
    }

}


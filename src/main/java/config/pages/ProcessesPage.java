package config.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;


public class ProcessesPage extends HomePage {


    @FindBy(css = ".title_left>h3")
    private WebElement processesHeader;

    @FindBy(css = "a[href=\"/Projects/Create\"]")
    private WebElement addNewProcessBtn;

    @FindBy(id = "Name")
    private WebElement processNameInput;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElement createBtn;

    @FindBy(css = "span.field-validation-error")
    private WebElement wrongProcessNameMessage;

    @FindBy(css = "a.btn-primary")
    private WebElement backToListBtn;


    public ProcessesPage(WebDriver driver) {
       super (driver);
    }

    public ProcessesPage assertProcessesUrl(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return this;

    }

    public ProcessesPage assertProcessesHeader() {
        Assert.assertTrue(processesHeader.isDisplayed());
        Assert.assertEquals(processesHeader.getText(), "Processes");
        return this;

    }

    private String GENERIC_PROCESS_ROW_XPATH = "//td[text()='%s']/..";

    public ProcessesPage assertProcess(String expName, String expDescription, String expNotes){
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, expName);

        WebElement processRow = driver.findElement(By.xpath(processXpath));

        String actDescription =
                processRow.findElement(By.xpath("./td[2]")).getText();
        String actNotes = processRow.findElement(By.xpath("./td[3]")).getText();

        Assert.assertEquals(actDescription, expDescription);
        Assert.assertEquals(actNotes,expNotes);

        return this;

    }

    public ProcessesPage assertProcessIsNotShown(String processName) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, processName);
        List<WebElement> process = driver.findElements(By.xpath(processXpath));
        Assert.assertEquals(process.size(), 0);

        return this;
    }


    public ProcessesPage clickAddNewProcess() {
        addNewProcessBtn.click();
        return this;
    }

    public ProcessesPage typeName(String processName) {
        processNameInput.sendKeys(processName);
        return this;
    }

    public ProcessesPage submitCreate() {
        createBtn.click();
        return this;
    }

    public ProcessesPage submitCreateWithFailure() {
        createBtn.click();
        return this;
    }

    public ProcessesPage assertProcessNameError() {
        Assert.assertEquals(wrongProcessNameMessage.getText(),"The field Name must be a string with a minimum length of 3 and a maximum length of 30.");
        return this;
    }


    public ProcessesPage backToList() {
        // i got 14 inch display ;)
        Actions actions = new Actions(driver);
        actions.moveToElement(backToListBtn).click().perform();
        return this;
    }
}


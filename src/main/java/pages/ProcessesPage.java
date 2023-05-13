package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ProcessesPage extends HomePage {


    @FindBy(css = ".title_left>h3")
    private WebElement processesHeader;


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

}


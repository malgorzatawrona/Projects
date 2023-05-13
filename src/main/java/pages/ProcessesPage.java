package pages;

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


}


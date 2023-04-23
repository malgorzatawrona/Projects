package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProcessesPage {
    protected WebDriver driver;

    public ProcessesPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}

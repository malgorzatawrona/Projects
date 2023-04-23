package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".profile_info>h2")
    private WebElement welcomeElm;

    public HomePage assertWelcomeElementIsShown() {
        Assert.assertTrue(welcomeElm.isDisplayed(), "Welcome element is not shown.");
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + welcomeElm.getText() + "' does not contain word 'Welcome'");

        return this;
    }

}
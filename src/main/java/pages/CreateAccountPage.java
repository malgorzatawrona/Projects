package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class CreateAccountPage {
    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = "#ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(id = "Email-error")
    public WebElement emailError;


    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public CreateAccountPage typeConfirmPassword(String confirmPassword) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(confirmPassword);
        return this;
    }

    public HomePage submitRegister() {
        registerBtn.click();
        return new HomePage(driver);
    }

    public CreateAccountPage submitRegisterWithFailure() {
        registerBtn.click();
        return this;

    }

    public CreateAccountPage assertCreateMessage() {
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");
        return this;
    }
}

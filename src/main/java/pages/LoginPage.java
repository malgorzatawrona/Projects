package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(id = "Email-error")
    public WebElement emailError;

    @FindBy (css = "a[href*=Register]")
    public WebElement registerLnk;


    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String Password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(Password);
        return this;
    }

    public HomePage submitLogin(){
        loginBtn.click();
        return new HomePage(driver);
    }
    public LoginPage submitLoginWithFailure(){
        loginBtn.click();
        return this;
    }

    public LoginPage expectLoginError(String expError){
        boolean doesErrorExists = loginErrors
                .stream()
                .anyMatch(validationError -> validationError.getText().equals(expError));
        Assert.assertTrue(doesErrorExists);
        return this;
    }

    public CreateAccountPage goToRegisterPage (){
        registerLnk.click();
        return new CreateAccountPage(driver);

    }

}

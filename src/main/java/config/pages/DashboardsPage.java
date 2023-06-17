package config.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class DashboardsPage extends HomePage {

    @FindBy(css = ".x_title>h2")
    public WebElement dashboardHeader;

    public DashboardsPage(WebDriver driver) {
        super(driver);
    }

    public DashboardsPage assertDashboardUrl(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return this;
    }

    public DashboardsPage assertDashboardHeader() {
        Assert.assertTrue(dashboardHeader.isDisplayed());
        Assert.assertEquals(dashboardHeader.getText(),"DEMO PROJECT");
        return this;
    }
}

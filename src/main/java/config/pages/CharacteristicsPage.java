package config.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CharacteristicsPage extends HomePage{

    @FindBy(css = ".title_left>h3")
    public WebElement characteristicsHeader;

    public CharacteristicsPage(WebDriver driver) {
       super(driver);
    }

    public CharacteristicsPage assertCharacteristicUrl(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        return this;
    }

    public CharacteristicsPage assertCharacteristicsHeader() {
        Assert.assertTrue(characteristicsHeader.isDisplayed());
        Assert.assertEquals(characteristicsHeader.getText(), "Characteristics");
        return this;
    }
}


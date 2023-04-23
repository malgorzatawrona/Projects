import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.time.Duration;

public class Lab_2_WebDriver {

    @Test
    public void playWithWebDriver (){
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://google.com" );

        WebElement agreeBtn = driver.findElement(By.cssSelector("#L2AGLb"));
        agreeBtn.click();

        WebElement searchTxt = driver.findElement(By.cssSelector( "textarea[name=q]"));
        searchTxt.sendKeys("Quality Assurance" + Keys.ENTER);

        driver.quit();


    }
}

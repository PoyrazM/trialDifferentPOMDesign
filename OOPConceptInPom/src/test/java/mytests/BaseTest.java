package mytests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypages.BasePage;
import mypages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {

    WebDriver driver;
    public Page page;

    @BeforeClass
    public void setUpTest(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://app.hubspot.com/login");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page = new BasePage(driver);
    }

    @AfterSuite
    public void tearDown(){
        if (driver !=null){
            driver.close();
            driver.quit();
        }
    }
}

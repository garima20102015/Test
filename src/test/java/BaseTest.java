import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by gtripathi on 6/9/2021.
 */
public class BaseTest extends Services {


  @BeforeSuite
    public static void beforeTest() throws IOException {
        Properties prop=Services.readFromPropertiesFile("./resources/config.properties");
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        Services.waitForElement("findFlightsButton");
    }



    @AfterTest
    public static void afterTest(){
        driver.close();
        



    }

    @AfterSuite
    public void afterSuite(){

        driver.quit();

    }

}

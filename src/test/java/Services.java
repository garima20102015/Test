import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.function.Function;


/**
 * Created by gtripathi on 6/9/2021.
 */
public class Services {

    public static WebDriver driver=new ChromeDriver();




    public static Properties readFromPropertiesFile(String path) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(path));
        return prop;
    }

    public static void findByNamehandType(String locator, String text) throws IOException {
        Properties prop= readFromPropertiesFile("./resources/OR.properties");
        driver.findElement(By.name(prop.getProperty(locator))).sendKeys(text);
    }

    public static void findByXpathandType(String locator, String text) throws IOException {
        Properties prop= readFromPropertiesFile("./resources/OR.properties");
        driver.findElement(By.xpath(prop.getProperty(locator))).sendKeys(text);
    }

    public static void clearAndEnter(String locator, String text) throws IOException {
        Properties prop= readFromPropertiesFile("./resources/OR.properties");
        driver.findElement(By.xpath(prop.getProperty(locator))).clear();
        driver.findElement(By.xpath(prop.getProperty(locator))).sendKeys(text);
    }

    public static void submit(String locator) throws IOException {
        Properties prop= readFromPropertiesFile("./resources/OR.properties");
        driver.findElement(By.xpath(prop.getProperty(locator))).click();
    }
    public static void waitForElement(String locator) throws IOException {
        Properties prop= readFromPropertiesFile("./resources/OR.properties");
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(locator))));
    }

    @DataProvider
    public Object[][] getCustomerData() throws IOException {
        Object[][] data = Utilities.getCellData("Flight Details");
        return data;
    }

    public static String getText(String locator) throws IOException {
        Properties prop= readFromPropertiesFile("./resources/OR.properties");
        return driver.findElement(By.xpath(prop.getProperty(locator))).getText();
    }
}

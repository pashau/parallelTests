/**
 * Created by pashau on 21.11.2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class AbstractTest {

    protected static boolean isRemoteTest = true;
    protected  WebDriver driver;
    private static String seleniumHubUrl;
    String className;

    //@BeforeSuite
    //@BeforeTest
    @BeforeClass
    //@BeforeMethod
    public void setUp() {
        openAndPrepareBrowser();
        long id = Thread.currentThread().getId();
        className = this.getClass().getName();
        System.out.println("Before "+className+". Thread id is: " + id);
    }
    //@AfterSuite
    //@AfterTest
    @AfterClass
    //@AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        long id = Thread.currentThread().getId();
        className = this.getClass().getName();
        System.out.println("After "+className+". Thread id is: " + id);
    }

    public void doPageCall(String url) {
        driver.get(url);
    }

    protected void openAndPrepareBrowser() {
        String propertyFile = "target/test-classes/environmentConfiguration.properties";
        Properties config = new Properties();

        try {
            config.load(new FileInputStream(propertyFile));
        } catch (IOException e) {
            org.testng.Assert.fail("Could not read config from file " + propertyFile);
        }
        isRemoteTest = Boolean.parseBoolean(config.getProperty("isRemote", "true"));
        seleniumHubUrl = config.getProperty("seleniumHubUrl");

        if (isRemoteTest) {
            driver = getRemoteDriver(seleniumHubUrl);
        } else {
            driver = getLocalDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    private static WebDriver getLocalDriver() {
        String chromeDir = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeDir + "/chromedriver.exe");
        return new ChromeDriver();
    }
    private static WebDriver getRemoteDriver(String seleniumHubUrl) {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), capabilities);
        } catch (MalformedURLException e) {
            org.testng.Assert.fail("Badly formed URL " + seleniumHubUrl);
        }
        return driver;
    }
}

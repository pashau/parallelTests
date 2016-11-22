import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by marsch on 17.11.2016.
 */
public class test extends AbstractTest{


    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test1() throws InterruptedException {
        doPageCall("https://google.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test1-method google. Thread id is: " + id);
    }
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test2() throws InterruptedException{
        doPageCall("https://sedo.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test1-method sedo. Thread id is: " + id);
    }
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test3() throws InterruptedException{
        doPageCall("https://amazon.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test1-method amazon. Thread id is: " + id);
    }
}
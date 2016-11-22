import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


/**
 * Created by marsch on 17.11.2016.
 */
public class test2 extends AbstractTest{
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test1() throws InterruptedException {
        doPageCall("https://facebook.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test1-method facebook. Thread id is: " + id);
    }
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test2() throws InterruptedException{
        doPageCall("https://ebay.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test2-method ebay. Thread id is: " + id);
    }
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test3()  throws InterruptedException{
        doPageCall("https://yahoo.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test2-method yahoo. Thread id is: " + id);
    }
}
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by marsch on 17.11.2016.
 */
public class test3 extends AbstractTest{
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test1() throws InterruptedException {
        doPageCall("https://gmx.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test1-method gmx. Thread id is: " + id);
    }
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test2() throws InterruptedException{
        doPageCall("https://youtube.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test1-method youtube. Thread id is: " + id);
    }
    @Test(threadPoolSize = 1, timeOut = 100000)
    public void test3() throws InterruptedException{
        doPageCall("https://xing.de");
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("Sample test1-method xing. Thread id is: " + id);
    }
}
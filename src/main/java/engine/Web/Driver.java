package engine.Web;

import engine.DriverBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver implements DriverBase {

    private static Driver driver;
    private WebDriver browser;

    private Driver(){
        open();
    }


    public static synchronized Driver getInstance(){
        if(driver == null)
            driver = new Driver();

        return driver;
    }

    @Override
    public void open() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.addArguments("--lang=pt");

        browser = new ChromeDriver();

        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();

        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Override
    public void close() {
        try{
            Thread.sleep(3000);
            browser.quit();
            driver = null;
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public WebDriver get() {
        return browser;
    }

    @Override
    public void set(WebDriver browser) {
        this.browser = browser;
    }
    @Override
    public WebDriverWait getWait(){
        return new WebDriverWait(browser, Duration.ofSeconds(30));
    }
}

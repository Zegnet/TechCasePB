package engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface DriverBase {

    void open();
    void close();
    WebDriver get();
    void set(WebDriver browser);
    WebDriverWait getWait();

}

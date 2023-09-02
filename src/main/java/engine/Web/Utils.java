package engine.Web;

import com.aventstack.extentreports.Status;
import engine.Reporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Utils {

    Logger logger = Logger.getLogger(Utils.class.getName());

    default void navigateTo(String url, String descriptionToAction){
        try{
            Driver.getInstance().get().navigate().to(url);
            Reporter.getInstance().Success(Status.PASS, descriptionToAction);
            logger.log(Level.WARNING, "[Passed] " + descriptionToAction + ": " + url);
        }catch (Exception e){
            Reporter.getInstance().Fail(Status.FAIL, descriptionToAction);
            logger.log(Level.SEVERE, "[Failed] " + descriptionToAction + ": " + url);
            throw new RuntimeException("ERROR", e);
        }
    }

    default void click(WebElement element, String descriptionToAction){
        try{
            Driver.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
            Reporter.getInstance().Success(Status.PASS, descriptionToAction);
            logger.log(Level.WARNING, "[Passed] " + descriptionToAction);
        }catch (Exception e) {
            Reporter.getInstance().Fail(Status.FAIL, descriptionToAction);
            logger.log(Level.SEVERE, "[Failed] " + descriptionToAction);
            throw new RuntimeException("ERROR", e);
        }
    }

    default void validate(WebElement element, String descriptionToAction){
        try{
            if(Driver.getInstance().getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed() && Driver.getInstance().getWait().until(ExpectedConditions.visibilityOf(element)).isEnabled()) {
                Reporter.getInstance().Success(Status.PASS, descriptionToAction);
                logger.log(Level.WARNING, "[Passed] " + descriptionToAction);
            }else{
                Reporter.getInstance().Fail(Status.FAIL, descriptionToAction);
                logger.log(Level.SEVERE, "[Failed] " + descriptionToAction);
            }
        }catch (Exception e) {
            throw new RuntimeException("ERROR", e);
        }
    }

    default void validate(List<WebElement> element, String descriptionToAction){
        try{
            if(!element.isEmpty()) {
                Reporter.getInstance().Success(Status.PASS, descriptionToAction);
                logger.log(Level.WARNING, "[Passed] " + descriptionToAction);
            }else {
                Reporter.getInstance().Fail(Status.FAIL, descriptionToAction);
                logger.log(Level.SEVERE, "[Failed] " + descriptionToAction);
            }
        }catch (Exception e) {
            throw new RuntimeException("ERROR", e);
        }
    }

}

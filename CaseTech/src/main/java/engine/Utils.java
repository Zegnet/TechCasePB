package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Utils {

    Logger logger = Logger.getLogger(Utils.class.getName());

    default void navigateTo(String url){
        try{
            Driver.getInstance().get().navigate().to(url);
            logger.log(Level.WARNING, "[Passed] Navegar até a página " + url);
        }catch (Exception e){
            logger.log(Level.SEVERE, "[Failed] Navegar até a página " + url);
            throw new RuntimeException("ERROR", e);
        }
    }

    default void click(WebElement element){
        try{
            Driver.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
            logger.log(Level.WARNING, "[Passed] Clicar no botão " + element.getText());
        }catch (Exception e) {
            logger.log(Level.SEVERE, "[Failed] Clicar no botão " + element.getText());
            throw new RuntimeException("ERROR", e);
        }
    }

    default void validate(WebElement element){
        try{
            if(Driver.getInstance().getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed() && Driver.getInstance().getWait().until(ExpectedConditions.visibilityOf(element)).isEnabled())
                logger.log(Level.WARNING, "[Passed] Objeto " + element + " apresentado e ativo");
            else
                logger.log(Level.SEVERE, "[Failed] Objeto " + element + " apresentado e ativo");
        }catch (Exception e) {
            throw new RuntimeException("ERROR", e);
        }
    }

    default void validate(List<WebElement> element){
        try{
            if(!element.isEmpty())
                logger.log(Level.WARNING, "[Passed] Objeto apresentado e ativo");
            else
                logger.log(Level.SEVERE, "[Failed] Objeto  apresentado e ativo");
        }catch (Exception e) {
            throw new RuntimeException("ERROR", e);
        }
    }

}

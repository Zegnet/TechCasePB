package Pages;

import Attributes.AttributesHome;
import engine.Utils;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class PageHome extends AttributesHome implements Utils {

    public PageHome(){
        super();
    }

    public PageHome buttonsValidate(){

        navigateTo("https://the-internet.herokuapp.com/challenging_dom");
        validate(button);
        click(button);
        click(alertButton);
        click(successButton);

        return this;
    }

    public PageHome editLinksValidade(){
        return this;
    }

    public PageHome deleteLinksValidade(){
        return this;
    }
}

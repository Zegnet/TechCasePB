package Web.Attributes;

import engine.Web.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AttributesHome {

    public AttributesHome(){
        PageFactory.initElements(Driver.getInstance().get(), this);
    }

    @FindBy(xpath = "//a[@class=\"button\"]")
    protected WebElement button;
    @FindBy(xpath = "//a[@class=\"button alert\"]")
    protected WebElement alertButton;
    @FindBy(xpath = "//a[@class=\"button success\"]")
    protected WebElement successButton;
    @FindBys(@FindBy(xpath = "//tbody/tr"))
    protected List<WebElement> rows;
    @FindBys(@FindBy(xpath = "//*[contains(text(),'edit')]"))
    protected List<WebElement> editLinks;
    @FindBys(@FindBy(xpath = "//*[contains(text(),'delete')]"))
    protected List<WebElement> deleteLinks;
}


import API.Statements.userStatements;
import Web.Pages.PageHome;
import engine.Web.Driver;
import engine.Reporter;
import engine.ScenarioBase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class Runner extends ScenarioBase {


    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void setupBeforeClass(){
        Reporter.getInstance();
    }

    @Before
    public void setupTest(){
        Reporter.getInstance().create(testName.getMethodName());
    }

    @Test
    public void testWeb(){
        Driver.getInstance();
        new PageHome().buttonsValidate().editLinksValidade().deleteLinksValidade();
        Driver.getInstance().close();
    }

    @Test
    public void testAPI(){
        new userStatements().validateUserRequest().validateJSONSchema();
    }
}

import Pages.PageHome;
import engine.Driver;
import engine.DriverBase;
import engine.ScenarioBase;
import org.junit.Before;
import org.junit.Test;

public class RunnerFunctional extends ScenarioBase {


    @Before
    public void setupTest(){
        Driver.getInstance();
    }

    @Test
    public void test(){
        new PageHome().buttonsValidate();
    }

}

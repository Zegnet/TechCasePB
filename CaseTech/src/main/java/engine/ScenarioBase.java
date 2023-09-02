package engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class ScenarioBase {

    public ScenarioBase(){
        System.out.println("A functional testing");
    }


    @After
    public void endTest(){
        Driver.getInstance().close();
    }


}

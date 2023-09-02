package engine;

import engine.Web.Driver;
import org.junit.After;
import org.junit.AfterClass;

public class ScenarioBase {

    public ScenarioBase(){
        System.out.println("Iniciando o Teste");
    }

    @AfterClass
    public static void entTestClass(){
        Reporter.getInstance().reportGenerator();
    }

}

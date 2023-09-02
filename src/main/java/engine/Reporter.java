package engine;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Reporter {
    private ExtentReports report;
    private ExtentTest test;
    private static Reporter reporter;
    protected Reporter(){
        Path currentPath = Paths.get("");
        String path = currentPath.toAbsolutePath().toString();
        ExtentSparkReporter spark = new ExtentSparkReporter(path  + "/TestReport.html");
        spark.config().setDocumentTitle("Tech Case - Paraná Banco");
        report = new ExtentReports();
        report.attachReporter(spark);

    }

    public static Reporter getInstance(){
        if(reporter == null)
            reporter = new Reporter();

        return reporter;
    }

    public void create(String testName){
        test = report.createTest(testName);
    }

    public void Fail(Status status, String descriptionToAction){
        assertTrue(descriptionToAction, Status.FAIL.equals(status));
        test.log(Status.FAIL, descriptionToAction);
    }

    public void Success(Status status, String descriptionToAction){
        assertTrue(descriptionToAction, Status.PASS.equals(status));
        test.log(Status.PASS, descriptionToAction);
    }

    public void reportGenerator(){
        report.flush();
    }

}

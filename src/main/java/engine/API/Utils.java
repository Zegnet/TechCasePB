package engine.API;

import com.aventstack.extentreports.Status;
import engine.Reporter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Utils {

    Logger logger = Logger.getLogger(Utils.class.getName());

    default Response post(RequestSpecification request){
        return RestAssured.given(request).post().then().extract().response();
    }
    default Response put(RequestSpecification request){
        return RestAssured.given(request).put().then().extract().response();
    }
    default Response delete(RequestSpecification request){
        return RestAssured.given(request).delete().then().extract().response();
    }
    default Response get(RequestSpecification request){
        return RestAssured.given(request).get().then().extract().response();
    }

    default void validateEquals(int expectedValue, int returnedValue, String descriptionToAction){
        if(expectedValue == returnedValue){
            Reporter.getInstance().Success(Status.PASS, descriptionToAction);
            logger.log(Level.WARNING, "[Passed] " + descriptionToAction);
        }else{
            Reporter.getInstance().Fail(Status.FAIL, descriptionToAction);
            logger.log(Level.SEVERE, "[Failed] " + descriptionToAction);
        }
    }

    default void validateResponse(Response response, String descriptionToAction){
        if(response.getBody().asString().indexOf("Expected") <= 0){
            Reporter.getInstance().Success(Status.PASS, descriptionToAction);
            logger.log(Level.WARNING, "[Passed] " + descriptionToAction);
        }else{
            int error = response.getBody().asString().indexOf("level: \"error\"");
            Reporter.getInstance().Fail(Status.FAIL, response.getBody().asString().substring(error));
            logger.log(Level.SEVERE, "[Failed] " + response.getBody().asString().substring(error));
        }
    }

    default Response validateJSONSchema(String schema, String endpoint){
        return RestAssured.given().header("Content-Type", "application/json; charset=utf-8").get(endpoint).then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schema)).extract().response();
    }
}

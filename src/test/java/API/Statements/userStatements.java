package API.Statements;

import API.Requests.userRequest;
import engine.API.Utils;
import io.restassured.response.Response;


public final class userStatements extends userRequest implements Utils{

    public userStatements validateUserRequest(){

        Response response = get(getUserRequest(1));
        validateEquals(200, response.getStatusCode(), "Validar Status Code 200 OK : GET METHOD");

        response = post(createUserRequest("Tech Test", "techtest"));
        validateEquals(201, response.getStatusCode(), "Validar Status Code 201 CREATED : POST METHOD");

        response = put(updateUser(1, "techtest"));
        validateEquals(200, response.getStatusCode(), "Validar Status Code 200 OK : PUT METHOD");

        response = delete(deleteUser(1));
        validateEquals(200, response.getStatusCode(), "Validar Status Code 200 OK : DELETE METHOD");
        return this;
    }

    public userStatements validateJSONSchema(){
        Response response = validateJSONSchema("userSchema.json", "http://jsonplaceholder.typicode.com/users/1");
        validateResponse(response, "Validar JSON Schema");
        return this;
    }

}

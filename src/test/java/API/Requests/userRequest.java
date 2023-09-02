package API.Requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
public abstract class userRequest {

    String host = "http://jsonplaceholder.typicode.com";
    public RequestSpecification getUserRequest(int userId){

        RequestSpecBuilder req = new RequestSpecBuilder();
        req.setBaseUri(host + "/users/" + userId);

        return req.build();

    }

    public RequestSpecification createUserRequest(String name, String username){

        String body = "{\n" +
                "        \"name\": \"" + name + ",\n" +
                "        \"username\": \"" + username + "\",\n" +
                "        \"email\": \"" + name + "@test.br\",\n" +
                "        \"address\": {\n" +
                "            \"street\": \"test\",\n" +
                "            \"suite\": \"Apt. 556\",\n" +
                "            \"city\": \"test\",\n" +
                "            \"zipcode\": \"92998-3874\",\n" +
                "            \"geo\": {\n" +
                "                \"lat\": \"-37.3159\",\n" +
                "                \"lng\": \"81.1496\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"phone\": \"1-770-736-8031 x56442\",\n" +
                "        \"website\": \"test.org\",\n" +
                "        \"company\": {\n" +
                "            \"name\": \"test\",\n" +
                "            \"catchPhrase\": \"Create an user to execute test automation\",\n" +
                "            \"bs\": \"may\"\n" +
                "        }\n" +
                "    }";

        RequestSpecBuilder req = new RequestSpecBuilder();
        req.setBaseUri(host + "/users");
        req.setBody(body);

        return req.build();

    }


    public RequestSpecification updateUser(int userId, String name){

        String body = "{\n" +
                "    \"name\": \"" + name + "\"\n" +
                "}";

        RequestSpecBuilder req = new RequestSpecBuilder();
        req.setBaseUri(host + "/users/" + userId);
        req.setBody(body);

        return req.build();

    }

    public RequestSpecification deleteUser(int userId){

        String body = "";

        RequestSpecBuilder req = new RequestSpecBuilder();
        req.setBaseUri(host + "/users/" + userId);
        req.setBody(body);

        return req.build();

    }

}

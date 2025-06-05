package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateHerOkuApp {

    public static String generateToken() {
        //set the url
        String url = "https://restful-booker.herokuapp.com/auth";

        //set the payload
        String payload = "{\n" +
                         "    \"username\" : \"admin\",\n" +
                         "    \"password\" : \"password123\"\n" +
                         "}";

        //send request get response
        Response response = given().body(payload).contentType(ContentType.JSON).when().post(url);

        //get token
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString("token");
    }

}
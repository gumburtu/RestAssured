package smoketest;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ReUsableMethods;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PartiallyUpdateBooking extends HerOkuAppBaseUrl {
      /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
        "firstname" : "Mehmet",
        "lastname" : "Can"
        }
    When
        Send patch request
    Then
        Status code is 200
    And
        Body:
        {
        "firstname" : "Mehmet",
        "lastname" : "Can",
        "totalprice" : 100,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
     */

    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first", "booking", "second", CreateBooking.bookingid);

        // 2- Set the expected data => Beklenen datayi ayarlayın
        Map<String, Object> payload = ReUsableMethods.jsonToMap("{\n" +
                                                                "        \"firstname\" : \"Mehmet\",\n" +
                                                                "        \"lastname\" : \"Can\"\n" +
                                                                "        }");

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();

        // 4- Do assertion => response tan doğrulamalar yapin
        Map<String, Object> actualData = response.as(HashMap.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(actualData.get("firstname"),payload.get("firstname"));
        softAssert.assertEquals(actualData.get("lastname"),payload.get("lastname"));
        softAssert.assertAll();



    }
}
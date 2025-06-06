package smoketest;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooking extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Send delete request
    Then
        Status code is 200
    And
        Body should be : "Created"
     */

    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first", "booking", "second", CreateBooking.bookingid);

        // 2- Set the expected data => Beklenen datayi ayarlayın
        String expectedData = "Created";

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        // 4- Do assertion => response tan doğrulamalar yapin
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(response.asString(),expectedData);

    }
}
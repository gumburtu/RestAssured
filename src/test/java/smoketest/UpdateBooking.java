package smoketest;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.HerOkuAppBookingDatesPojo;
import pojos.HerOkuAppGetResponsePojo;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends HerOkuAppBaseUrl {
     /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
        "firstname" : "Ali",
        "lastname" : "Can",
        "totalprice" : 100,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
    When
        Send put request
    Then
        Status code is 200
    And
        Body:
        {
        "firstname" : "Ali",
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
        HerOkuAppBookingDatesPojo bookingDatesPojo = new HerOkuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerOkuAppGetResponsePojo expectedData = new HerOkuAppGetResponsePojo("Ali", "Can", 100, true, bookingDatesPojo, "Dinner");

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();

        // 4- Do assertion => response tan doğrulamalar yapin
        HerOkuAppGetResponsePojo actualData = response.as(HerOkuAppGetResponsePojo.class);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actualData.getFirstname(), expectedData.getFirstname());
        Assert.assertEquals(actualData.getLastname(), expectedData.getLastname());
        Assert.assertEquals(actualData.getTotalprice(), expectedData.getTotalprice());
        Assert.assertEquals(actualData.getDepositpaid(), expectedData.getDepositpaid());
        Assert.assertEquals(actualData.getBookingdates().getCheckin(), bookingDatesPojo.getCheckin());
        Assert.assertEquals(actualData.getBookingdates().getCheckout(), bookingDatesPojo.getCheckout());
        Assert.assertEquals(actualData.getAdditionalneeds(), expectedData.getAdditionalneeds());

    }
}
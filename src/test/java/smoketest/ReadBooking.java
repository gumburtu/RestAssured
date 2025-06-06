package smoketest;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.HerOkuAppBookingDatesPojo;
import pojos.HerOkuAppGetResponsePojo;
import pojos.HerOkuAppPostResponsePojo;

import static io.restassured.RestAssured.given;

public class ReadBooking extends HerOkuAppBaseUrl {
     /*
   Given
   https://restful-booker.herokuapp.com/booking/:id
   When
   Send get request
           Then
   Status code is 200
   And
   Body:
   {
       "firstname": "Jim",
           "lastname": "Brown",
           "totalprice": 111,
           "depositpaid": true,
           "bookingdates": {
       "checkin": "2018-01-01",
               "checkout": "2019-01-01"
   },
       "additionalneeds": "Breakfast"
   }
    */

    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        //https://restful-booker.herokuapp.com/booking/{{bookingID}}
        spec.pathParams("first", "booking", "second", CreateBooking.bookingid);
        System.out.println("CreateBooking.bookingid = " + CreateBooking.bookingid);

        // 2- Set the expected data => Beklenen datayi ayarlayın
        HerOkuAppBookingDatesPojo bookingDatesPojo = new HerOkuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerOkuAppGetResponsePojo expectedData = new HerOkuAppGetResponsePojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).when().get("{first}/{second}");

        // 4- Do assertion => response tan doğrulamalar yapin
        response.prettyPrint();
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
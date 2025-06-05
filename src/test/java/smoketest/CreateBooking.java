package smoketest;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.HerOkuAppBookingDatesPojo;
import pojos.HerOkuAppGetResponsePojo;
import pojos.HerOkuAppPostResponsePojo;

import static io.restassured.RestAssured.given;

public class CreateBooking extends HerOkuAppBaseUrl {

      /*
   Given
       https://restful-booker.herokuapp.com/booking
   And
       {
           "firstname" : "Jim",
           "lastname" : "Brown",
           "totalprice" : 111,
           "depositpaid" : true,
           "bookingdates" : {
               "checkin" : "2018-01-01",
               "checkout" : "2019-01-01"
           },
           "additionalneeds" : "Breakfast"
       }
    When
       Send post request
    Then
       Status code is 200
    And
       Body:
        {
           "bookingid": 1,
           "booking": {
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
       }
    */


    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first","booking");

        // 2- Set the expected data => Beklenen datayi ayarlayın
        HerOkuAppBookingDatesPojo bookingDatesPojo = new HerOkuAppBookingDatesPojo("2018-01-01","2019-01-01");
        HerOkuAppGetResponsePojo expectedData = new HerOkuAppGetResponsePojo("Jim","Brown",111,true,bookingDatesPojo,"Breakfast");

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(expectedData).when().post("{first}");

        // 4- Do assertion => response tan doğrulamalar yapin
        response.prettyPrint();
        HerOkuAppPostResponsePojo actualData = response.as(HerOkuAppPostResponsePojo.class);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(actualData.getBooking().getFirstname(),expectedData.getFirstname());
        Assert.assertEquals(actualData.getBooking().getLastname(),expectedData.getLastname());
        Assert.assertEquals(actualData.getBooking().getTotalprice(),expectedData.getTotalprice());
        Assert.assertEquals(actualData.getBooking().getDepositpaid(),expectedData.getDepositpaid());
        Assert.assertEquals(actualData.getBooking().getBookingdates().getCheckin(),bookingDatesPojo.getCheckin());
        Assert.assertEquals(actualData.getBooking().getBookingdates().getCheckout(),bookingDatesPojo.getCheckout());
        Assert.assertEquals(actualData.getBooking().getAdditionalneeds(),expectedData.getAdditionalneeds());

    }
}
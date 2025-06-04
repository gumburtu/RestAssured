package get_requests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.HerOkuAppBookingDatesPojo;
import pojos.HerOkuAppGetResponsePojo;

import static io.restassured.RestAssured.given;

public class Get10  extends HerOkuAppBaseUrl {

    /*
 Given
     https://restful-booker.herokuapp.com/booking/722
 When
     I send GET Request to the url
 Then
     Response body should be like that;
     {
         "firstname": "John",
         "lastname": "Smith",
         "totalprice": 111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2018-01-01",
             "checkout": "2019-01-01"
         },
         "additionalneeds": "Dinner"
     }
 */

    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first","booking","second",4034);

        // 2- Set the expected data => Beklenen datayi ayarlayın
        HerOkuAppBookingDatesPojo bookingDatesPojo = new HerOkuAppBookingDatesPojo("2018-01-01","2019-01-01");
        HerOkuAppGetResponsePojo expectedData = new HerOkuAppGetResponsePojo("John","Smith",111,true,bookingDatesPojo,"Dinner");

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).when().get("{first}/{second}");

        // 4- Do assertion => response tan doğrulamalar yapin
        HerOkuAppGetResponsePojo actualData = response.as(HerOkuAppGetResponsePojo.class);
        Assert.assertEquals(actualData.getFirstname(),expectedData.getFirstname());
        Assert.assertEquals(actualData.getLastname(),expectedData.getLastname());
        Assert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice());
        Assert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid());
        Assert.assertEquals(actualData.getBookingdates().getCheckin(),bookingDatesPojo.getCheckin());
        Assert.assertEquals(actualData.getBookingdates().getCheckout(),bookingDatesPojo.getCheckout());
        Assert.assertEquals(actualData.getAdditionalneeds(),expectedData.getAdditionalneeds());


    }
}
package smoketest;

import baseurl.HerOkuAppBaseUrl;
import org.testng.annotations.Test;

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
        //https://restful-booker.herokuapp.com/booking/{bookingID}
        spec.pathParams("first", "booking", {{bookingID}});
        
        // 2- Set the expected data => Beklenen datayi ayarlayın
        // 3- Send request get response => isteği gönderin ve cevabi alin
        // 4- Do assertion => response tan doğrulamalar yapin
    }
}
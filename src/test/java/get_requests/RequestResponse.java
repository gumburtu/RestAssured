package get_requests;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class RequestResponse {

    /*
    1) Manual API testleri icin Postman kullanacağız
       Otomasyon testleri icin Rest Assured Library kullanacağız

    2) Rest Assured, Gherkin dilinden faydalanarak hazir methodlar olusturmustur.
       a) given()   : PreConditions (ön kosullar)
       b) when()    : Actions get(), post()..
       c) then()    : Assertions (doğrulamalar)
       d) and()     : Coklu durumlari baglarken okunurluk acisindan kullanilabilir

    3) API Otomasyon testlerimizi yazarken asagidaki adimlari izleyebiliriz
        1- Set the url =>API in end pointi ayarlayin
        2- Set the expected data => Beklenen datayi ayarlayın
        3- Send request get response => isteği gönderin ve cevabi alin
        4- Do assertion => response tan doğrulamalar yapin
     */

    @Test
    public void test01() {
        RestAssured.given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .log().all();
    }
}
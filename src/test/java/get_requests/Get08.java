package get_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
    Given
       https://jsonplaceholder.typicode.com/todos
    When
       Kullanıcı URL'e bir GET request gönderir
    Then
        Status code 200 olmalı
        "Id"leri 190 dan büyük olanları konsola yazdırın
        "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
 */

    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first", "todos");

        // 2- Set the expected data => Beklenen datayi ayarlayın
        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
        System.out.println("========================================");

        // 4- Do assertion => response tan doğrulamalar yapin

        JsonPath jsonPath = response.jsonPath();
        List<Object> idList = jsonPath.getList("id");
        System.out.println("idList = " + idList);
        System.out.println("========================================");


        //================assertion=============================
        // Status code 200 olmalı
        // "Id"leri 190 dan büyük olanları konsola yazdırın
        // "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        // "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        // "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        // "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        // "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın


    }
}
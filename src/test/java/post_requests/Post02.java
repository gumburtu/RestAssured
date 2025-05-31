package post_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import org.testng.annotations.Test;

public class Post02 extends JsonPlaceHolderBaseUrl {

  /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }

        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            Status code 201 olmalı
        And
            Response şu şekilde olmalı:
            {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201
            }
     */


    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first","todos");

        // 2- Set the expected data / payload => Beklenen datayi ayarlayın
        /*
        String kullanmak ta bir yöntemdir ama assertion icin bu kullanimi tavsiye etmiyoruz
         */
        String payload="{\n" +
                       "             \"userId\": 55,\n" +
                       "             \"title\": \"Tidy your room\",\n" +
                       "             \"completed\": false\n" +
                       "           }";

        // 3- Send request get response => isteği gönderin ve cevabi alin

        // 4- Do assertion => response tan doğrulamalar yapin

    }
}
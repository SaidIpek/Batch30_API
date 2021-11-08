package com.techproed.Day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    //https://restful-booker.herokuapp.com/booking/3 adresine
    // bir request gonderildiginde donecek cevap(response) icin
    //HTTP status kodunun 200
    //Content Type'in Json
    //Ve Status Line'in HTTP/1.1 200 OK
    //Oldugunu test edin

    //API TEST BASLANGIC---------

    @Test
            public void test() {


        //1- api testi yaparken ilk olarak url belirlenmeli.(endpoint)

        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2- beklenen sonuc (expected result) olusturulur.
        //bu case'de benden body dogrulaması istenmeigi icin simdilik beklenen sonuc olusturmyoruz

        //3-request gonderiyoruz.

        Response response = given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();


        //4- actual result olusturuyoruz
        //response body ile ilgili islem yapmayacagımız icin simdi olusturmyacagız.

        //5- dogrulama yap(assertion)
        System.out.println("status code : "+response.getStatusCode()); //200
        System.out.println("content type : "+ response.getContentType()); //application/json; charset=utf-8
        System.out.println("status line : "+response.getStatusLine()); //HTTP/1.1 200 OK
        System.out.println("All Headers :\n" + response.getHeaders());



        Assert.assertEquals(200,response.getStatusCode());
        //expected kismi bize task olarak verilen degerdir, actual kismi ise response'dan donen degerdir.
        //status code int deger dondurur.
        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());


        //Assert etmede 2. yontem ==============
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");




    }
}

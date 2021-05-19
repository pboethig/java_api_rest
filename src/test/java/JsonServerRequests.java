package test.java;

import apitesting.com.org.classes.Info;
import apitesting.com.org.classes.Posts;
import apitesting.com.org.classes._Posts;
import com.jayway.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class JsonServerRequests {

    @Test
    public void test_01(){
        Response response = given().when().get("http://localhost:3000/posts");
        System.out.println(response.asString());
    }

    @Test
    public void test_02(){

        String json = "{" +
                "    \"id\": 2," +
                "    \"title\": \"wtf\"," +
                "    \"author\": \"Peter\"" +
                "  }";

        Response response2 = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/posts/2");

        System.out.println(response2.asString());

        Response response = given()
                .body(json)
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:3000/posts");

        System.out.println(response.asString());
    }

    @Test
    public void test_03(){
        Posts posts = new Posts();

        posts.setId("4");;
        posts.setAuthor("Peter2");
        posts.setTitle("WTF3");

        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/posts/4");


        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(posts)
                .post("http://localhost:3000/posts");

        Assert.assertEquals(201, response.getStatusCode());

        System.out.println(response.asString());
    }

    @Test
    public void test_04(){
        Posts posts = new Posts();

        posts.setAuthor("Peter2");

        String json = "{" +
                "    \"title\": \"wtf4444\"" +
                "  }";

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(json)
                .patch("http://localhost:3000/posts/1");

        Assert.assertEquals(200, response.getStatusCode());

        System.out.println(response.asString());
    }

    @Test
    public void test_05(){

        Info info = new Info();
        info.setAddress("Starsse1");
        info.setEmail("pb@gamil.com");
        info.setPhone("11111");

        _Posts posts = new _Posts();

        posts.setAuthor("Peter2");

        posts.setInfo(info);

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(posts)
                .patch("http://localhost:3000/posts/1");

        Assert.assertEquals(200, response.getStatusCode());

        System.out.println(response.asString());
    }

    @Test
    public void test_010() {

        Response response = given()
                .when()
                .get("http://localhost:3000/posts");

        long time = response
                .then().
                extract().time();

        System.out.println(time);

        given()
                .when()
                .get("http://localhost:3000/posts")
                .then()
                .and()
                .time(lessThan(100L));
    }
}

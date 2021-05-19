package test.java;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

public class WheaterGetRequest {

	@Test
	public void Test_01() {

		String url = "https://api.openweathermap.org/data/2.5/weather?q=Munich&appid=d9683a8977a924e5b9ea6cd77afdc29b";

		Response response =when().get(url);

		Assert.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void Test_03() {

		String url = "https://api.openweathermap.org/data/2.5/weather";

			given()
					.param("q","London")
					.param("appid","d9683a8977a924e5b9ea6cd77afdc29b")
					.when()
					.get(url)
					.then()
					.assertThat().statusCode(200);
	}

	@Test
	public void Test_04() {

		String url = "https://api.openweathermap.org/data/2.5/weather";

		Response response = given()
				.param("q","Munich")
				.param("appid","d9683a8977a924e5b9ea6cd77afdc29b")
				.when()
				.get(url);

		System.out.println(response.asString());
	}

	@Test
	public void Test_05() {

		String url = "https://api.openweathermap.org/data/2.5/weather";

		Response response = given()
				.param("id","2172797")
				.param("appid","d9683a8977a924e5b9ea6cd77afdc29b")
				.when()
				.get(url);

		Assert.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void Test_06() {

		String url = "https://api.openweathermap.org/data/2.5/weather";

		Response response = given()
				.param("zip","85521,de")
				.param("appid","d9683a8977a924e5b9ea6cd77afdc29b")
				.when()
				.get(url);

		Assert.assertEquals(200,response.getStatusCode());
	}

	@Test
	public void Test_07() {

		String url = "https://api.openweathermap.org/data/2.5/weather";

		Response response = given()
				.param("zip","85521,de")
				.param("appid","d9683a8977a924e5b9ea6cd77afdc29b")
				.when()
				.get(url);

		String weather = response.then()
				.contentType(ContentType.JSON)
				.and()
				.extract().path("weather[0].description");

		Assert.assertNotEquals("bullshit", weather);
	}

	@Test
	public void test_11() {

		String url = "https://api.openweathermap.org/data/2.5/weather";

		Response response = given()
				.param("zip", "85521,de")
				.param("appid", "d9683a8977a924e5b9ea6cd77afdc29b")
				.when()
				.get(url);

		String reportId = response
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.path("weather[0].description");

		Assert.assertNotEquals("bullshithoch2", reportId);


		String longtitude = response
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.path("coord.lon")
				.toString();

		Assert.assertEquals("11.6686", longtitude);

		String latitude = response
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.path("coord.lat")
				.toString();

		Assert.assertEquals("48.0624", latitude);

	}
}

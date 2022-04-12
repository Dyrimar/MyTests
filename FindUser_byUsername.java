package Tests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.io.IOException;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class FindUser_byUsername {
    @Test
    public void FindUser() {
        Response response = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user/{username}")
                .pathParam("username", "John")
                .header("api_key", "api_key")
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Accept-Encoding","gzip, deflate, br")
                .when()
                .get()
                .then()
                .extract().response();

        System.out.println(response.getBody().asString());
        assertEquals(200, response.getStatusCode(), "Server status responce not a expected");
        System.out.println(response.statusCode());
    }
}

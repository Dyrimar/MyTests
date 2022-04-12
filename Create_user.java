package Tests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.io.IOException;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Create_user {
    @Test
    public void create_user1() {
        String s = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Dyrimar\",\n" +
                "  \"firstName\": \"Anton\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        Response response = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/user")
                .header("api_key", "api_key")
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .header("Accept-Encoding","gzip, deflate, br")
                .body(s)
                .when()
                .post()
                .then()
                .extract().response();
        assertEquals(200, response.getStatusCode(), "Server status responce not a expected");
        System.out.println(response.statusCode());
        System.out.println(s);

    }
}

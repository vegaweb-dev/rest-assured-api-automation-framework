package negative;

import clients.UserClient;
import configuration.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class UserNegativeTests {
    @Test
    public void shouldReturnNotFoundWhenResourceDoesNotExist() {
        UserClient
                .getUserById(20354)
                .then()
                .statusCode(404);
    }
}

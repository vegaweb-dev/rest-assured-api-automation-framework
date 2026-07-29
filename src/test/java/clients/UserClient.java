package clients;

import configuration.RestAssuredConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public static Response getUserById(int userId) {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .when()
                .get("/users/%s".formatted(userId))
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static Response createUser() {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .body("""
                        {
                        "name":"Aaaarav Sharma",
                        "email":"cv%s@example.com",
                        "gender":"male",
                        "status":"active"
                        }
                        """.formatted(System.currentTimeMillis()))
                .when()
                .post("/users")
                .then()
                .extract()
                .response();
    }

    public static Response updateUser(int userId) {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .body("""
                        {"name":"Carlos",
                        "email":"cv%s@example.com",
                        "gender":"male",
                        "status":"active"
                        }
                        """.formatted(System.currentTimeMillis())
                )
                .when()
                .put("/users/%s".formatted(userId))
                .then()
                .extract()
                .response();
    }

    public static Response updateUserPartially(int userId) {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .body("""
                        {"status":"inactive"}
                        """.formatted(System.currentTimeMillis()))
                .when()
                .patch("/users/%d".formatted(userId))
                .then()
                .extract()
                .response();
    }

    public static Response deleteUser(int userId) {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .when()
                .delete("/users/%s".formatted(userId))
                .then()
                .extract()
                .response();
    }
}

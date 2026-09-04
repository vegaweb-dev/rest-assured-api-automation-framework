package clients;

import configuration.RestAssuredConfig;
import io.restassured.response.Response;
import models.requests.UserCreateRequest;
import models.requests.UserPatchRequest;

import static io.restassured.RestAssured.given;

public class UserClient {
    public static Response getUserById(int userId) {
        return given(RestAssuredConfig.publicRequestSpecification())
                .when()
                .get("/users/%s".formatted(userId))
                .then()
                .extract()
                .response();
    }

    public static Response createUser(UserCreateRequest createRequestBody) {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .body(createRequestBody)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();
    }

    public static Response updateUser(UserCreateRequest updateRequestBody,
                                      int userId) {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .body(updateRequestBody)
                .when()
                .put("/users/%s".formatted(userId))
                .then()
                .extract()
                .response();
    }

    public static Response patchUser(UserPatchRequest patchRequestBody,
                                 int userId) {
        return given(RestAssuredConfig.authenticatedRequestSpecification())
                .body(patchRequestBody)
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

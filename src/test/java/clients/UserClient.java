package clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.requests.UserCreateRequest;
import models.requests.UserPatchRequest;

import static io.restassured.RestAssured.given;

public class UserClient {
    private final RequestSpecification requestSpecification;

    public UserClient(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response getUsers() {
        return given(requestSpecification)
                .when()
                .get("/users")
                .then()
                .extract()
                .response();
    }

    public Response getUserById(int userId) {
        return given(requestSpecification)
                .when()
                .get("/users/%s".formatted(userId))
                .then()
                .extract()
                .response();
    }

    public Response createUser(UserCreateRequest createRequestBody) {
        return given(requestSpecification)
                .body(createRequestBody)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();
    }

    public Response updateUser(UserCreateRequest updateRequestBody,
                               int userId) {
        return given(requestSpecification)
                .body(updateRequestBody)
                .when()
                .put("/users/%s".formatted(userId))
                .then()
                .extract()
                .response();
    }

    public Response patchUser(UserPatchRequest patchRequestBody,
                              int userId) {
        return given(requestSpecification)
                .body(patchRequestBody)
                .when()
                .patch("/users/%d".formatted(userId))
                .then()
                .extract()
                .response();
    }

    public Response deleteUser(int userId) {
        return given(requestSpecification)
                .when()
                .delete("/users/%s".formatted(userId))
                .then()
                .extract()
                .response();
    }
}

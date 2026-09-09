package negative;

import fixtures.UserClientFixture;
import io.restassured.response.Response;
import models.requests.UserCreateRequest;
import org.junit.jupiter.api.Test;
import testdata.UserTestData;


public class UserNegativeTests {
    @Test
    void shouldReturnNotFoundWhenResourceDoesNotExist() {
        UserClientFixture
                .userClientWithoutAuthentication()
                .getUserById(20354)
                .then()
                .statusCode(404);
    }

    @Test
    void shouldReturnUnauthorizedWhenTokenIsMissing() {
        int userId = -1;
        try {
            UserCreateRequest requestBody =
                    UserCreateRequest.builder()
                                     .withName(UserTestData.validName())
                                     .withEmail(UserTestData.validEmail())
                                     .withGender(UserTestData.validGender())
                                     .withStatus(UserTestData.validStatus())
                                     .build();

            Response createUserResponse = UserClientFixture.userClientWithAuthentication()
                                                           .createUser(requestBody);
            createUserResponse.then()
                              .statusCode(201);

            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            Response deleteUserResponse = UserClientFixture.userClientWithoutAuthentication()
                                                           .deleteUser(userId);
            deleteUserResponse.then()
                              .statusCode(401);

        } finally {
            try {
                if (userId != -1) {
                    Response deleteUserResponse =
                            UserClientFixture.userClientWithAuthentication()
                                             .deleteUser(userId);
                    deleteUserResponse.then()
                                      .statusCode(204);
                }
            } catch (Exception e) {
                System.err.println("User could not be deleted. Error: " + e);
            }
        }
    }
}

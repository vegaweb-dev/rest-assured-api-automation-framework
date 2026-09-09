package crud;

import fixtures.UserClientFixture;
import io.restassured.response.Response;
import models.requests.UserCreateRequest;
import models.requests.UserPatchRequest;
import org.junit.jupiter.api.Test;
import testdata.UserTestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCrudTest {

    @Test
    void shouldReturnUsersWhenApiIsAvailable() {
        Response getResponse =
                UserClientFixture.userClientWithoutAuthentication()
                                 .getUsers();
        getResponse.then()
                   .statusCode(200);
    }

    @Test
    void shouldReturnOneUserWhenUserExists() {

        int userId = -1;

        try {
            UserCreateRequest createRequestBody =
                    UserCreateRequest
                            .builder()
                            .withName(UserTestData.validName())
                            .withEmail(UserTestData.validEmail())
                            .withGender(UserTestData.validGender())
                            .withStatus(UserTestData.validStatus())
                            .build();
            Response createUserResponse =
                    UserClientFixture.userClientWithAuthentication()
                                     .createUser(createRequestBody);
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            Response getUserResponse =
                    UserClientFixture.userClientWithoutAuthentication()
                                     .getUserById(userId);
            getUserResponse.then()
                           .statusCode(200);
            assertEquals(
                    userId,
                    getUserResponse.jsonPath()
                                   .getInt("id"));
            userId = -1;
        } finally {
            try {
                if (userId != -1) {
                    UserClientFixture.userClientWithAuthentication()
                                     .deleteUser(userId);
                }
            } catch (Exception e) {
                System.err.println("User could not be deleted. Error: " + e);
            }
        }
    }

    @Test
    void shouldCreateOneUserWhenRequestIsValid() {

        int userId = -1;

        try {
            UserCreateRequest createRequestBody =
                    UserCreateRequest
                            .builder()
                            .withName(UserTestData.validName())
                            .withEmail(UserTestData.validEmail())
                            .withGender(UserTestData.validGender())
                            .withStatus(UserTestData.validStatus())
                            .build();

            Response createUserResponse =
                    UserClientFixture.userClientWithAuthentication()
                                     .createUser(createRequestBody);
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");
            assertEquals(
                    UserTestData.validName(),
                    createUserResponse.jsonPath()
                                      .getString("name"));
            userId = -1;
        } finally {
            try {
                if (userId != -1) {
                    UserClientFixture.userClientWithAuthentication()
                                     .deleteUser(userId);
                }
            } catch (Exception e) {
                System.err.println("User could not be deleted. Error :" + e);
            }
        }
    }

    @Test
    void shouldReplaceUserWhenUserExists() {

        int userId = -1;

        try {
            UserCreateRequest createRequestBody =
                    UserCreateRequest.builder()
                                     .withName("testName created")
                                     .withEmail(UserTestData.validEmail())
                                     .withGender(UserTestData.validGender())
                                     .withStatus(UserTestData.validStatus())
                                     .build();
            Response createUserResponse =
                    UserClientFixture.userClientWithAuthentication()
                                     .createUser(createRequestBody);
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            UserCreateRequest updateRequestBody = UserCreateRequest
                    .builder()
                    .withName("testName replaced")
                    .withEmail(UserTestData.validEmail())
                    .withGender(UserTestData.validGender())
                    .withStatus(UserTestData.validStatus())
                    .build();
            Response updateUserResponse =
                    UserClientFixture.userClientWithAuthentication()
                                     .updateUser(updateRequestBody, userId);
            updateUserResponse.then()
                              .statusCode(200);

            assertEquals("testName replaced",
                    updateUserResponse.jsonPath()
                                      .getString("name"));
            userId = -1;

        } finally {
            try {
                if (userId != -1) {
                    UserClientFixture.userClientWithAuthentication()
                                     .deleteUser(userId);
                }
            } catch (Exception e) {
                System.err.println("User could not be removed. Error :" + e);
            }
        }
    }

    @Test
    void shouldUpdateUserPartiallyWhenUserExists() {

        int userId = -1;

        try {
            UserCreateRequest createRequestBody =
                    UserCreateRequest.builder()
                                     .withName(UserTestData.validName())
                                     .withEmail(UserTestData.validEmail())
                                     .withGender(UserTestData.validGender())
                                     .withStatus(UserTestData.validStatus())
                                     .build();
            Response createUserResponse =
                    UserClientFixture.userClientWithAuthentication()
                                     .createUser(createRequestBody);

            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            UserPatchRequest updatePartiallyRequestBody =
                    UserPatchRequest.builder()
                                    .withStatus("inactive")
                                    .build();

            Response updateUserPartiallyResponse =
                    UserClientFixture.userClientWithAuthentication()
                                     .patchUser(updatePartiallyRequestBody,
                                             userId);
            updateUserPartiallyResponse.then()
                                       .statusCode(200);
            assertEquals(
                    "inactive",
                    updateUserPartiallyResponse.jsonPath()
                                               .getString("status"));
            userId = -1;

        } finally {
            try {
                if (userId != -1) {
                    UserClientFixture.userClientWithAuthentication()
                                     .deleteUser(userId);
                }
            } catch (Exception e) {
                System.err.println("User could not be deleted. Error: " + e);
            }
        }
    }

    @Test
    void shouldDeleteUserWhenUserExists() {

        int userId = -1;

        try {
            UserCreateRequest createRequestBody =
                    UserCreateRequest.builder()
                                     .withName(UserTestData.validName())
                                     .withEmail(UserTestData.validEmail())
                                     .withGender(UserTestData.validGender())
                                     .withStatus(UserTestData.validStatus())
                                     .build();
            Response createUserResponse =
                    UserClientFixture.userClientWithAuthentication()
                                     .createUser(createRequestBody);

            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            Response deleteUserResponse = UserClientFixture.userClientWithAuthentication()
                                                           .deleteUser(userId);
            deleteUserResponse.then()
                              .statusCode(204);
            userId = -1;
        } finally {
            try {
                if (userId != -1) {
                    UserClientFixture.userClientWithAuthentication()
                                     .deleteUser(userId);
                }
            } catch (Exception e) {
                System.err.println("User could not be deleted. Error: " + e);
            }
        }
    }
}

























































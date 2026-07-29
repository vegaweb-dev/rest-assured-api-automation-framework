package smoke;

import clients.UserClient;
import configuration.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserSmokeTest {

    @Test
    void shouldReturnUsersWhenApiIsAvailable() {
        given(RestAssuredConfig.publicRequestSpecification())
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }

    @Test
    void shouldReturnOneUserWhenUserExists() {

        int userId = -1;

        try {
            Response createUserResponse = UserClient.createUser();
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            Response getUserResponse = UserClient.getUserById(userId);
            getUserResponse.then()
                           .statusCode(200);
            assertEquals(
                    userId,
                    getUserResponse.jsonPath()
                                   .getInt("id"));
        } finally {
            try {
                if (userId != -1) {
                    UserClient.deleteUser(userId);
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
            Response createUserResponse = UserClient.createUser();
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");
            assertEquals(
                    "Aaaarav Sharma",
                    createUserResponse.jsonPath()
                                      .getString("name"));
        } finally {
            try {
                if (userId != -1) {
                    UserClient.deleteUser(userId);
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
            Response createUserResponse = UserClient.createUser();
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");
            Response updateResponse = UserClient.updateUser(userId);
            updateResponse.then()
                          .statusCode(200);
            assertEquals("Carlos",
                    updateResponse.jsonPath()
                                  .getString("name"));

        } finally {
            try {
                if (userId != -1) {
                    UserClient.deleteUser(userId);
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
            Response createUserResponse = UserClient.createUser();
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            Response updateUserPartiallyResponse =
                    UserClient.updateUserPartially(userId);
            updateUserPartiallyResponse.then()
                                       .statusCode(200);
            assertEquals(
                    "inactive",
                    updateUserPartiallyResponse.jsonPath()
                                               .getString("status")
            );
        } finally {
            try {
                if (userId != -1) {
                    UserClient.deleteUser(userId);
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
            Response createUserResponse = UserClient.createUser();
            createUserResponse.then()
                              .statusCode(201);
            userId = createUserResponse.jsonPath()
                                       .getInt("id");

            Response deleteUserResponse = UserClient.deleteUser(userId);
            deleteUserResponse.then()
                              .statusCode(204);
            userId = -1;
        } finally {
            try {
                if (userId != -1) {
                    UserClient.deleteUser(userId);
                }
            } catch (Exception e) {
                System.err.println("User could not be deleted. Error: " + e);
            }
        }
    }
}

























































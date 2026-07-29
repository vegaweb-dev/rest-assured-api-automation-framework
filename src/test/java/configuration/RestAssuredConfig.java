package configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RestAssuredConfig {
    public static final String BASE_URI = "https://gorest.in/public/v2";
    public static final String TOKEN = "demo-token";

    private RestAssuredConfig() {
    }

    public static RequestSpecification publicRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();
    }

    public static RequestSpecification authenticatedRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setContentType(ContentType.JSON)
                .build();
    }


}
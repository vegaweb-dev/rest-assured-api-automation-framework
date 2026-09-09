package configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public final class RestAssuredConfig {
    public static final String BASE_URI = "https://gorest.in/public/v2";

    private RestAssuredConfig() {
    }

    public static RequestSpecification authenticatedRequestSpecification() {
        String token = System.getenv("GOREST_TOKEN");
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Authorization", "Bearer " + token)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification unauthenticatedRequestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }


}
package fixtures;

import clients.UserClient;
import configuration.RestAssuredConfig;

public class UserClientFixture {
    public static UserClient userClientWithoutAuthentication(){
        return new UserClient(RestAssuredConfig.unauthenticatedRequestSpecification());
    }

    public static UserClient userClientWithAuthentication(){
        return new UserClient(RestAssuredConfig.authenticatedRequestSpecification());
    }

    public static UserClient userClientWithBlockedAuthentication(){
        return  new UserClient(RestAssuredConfig.forbiddenRequestSpecification());
    }
}

package models.requests;

public class UserCreateRequest {
    private final String name;
    private final String email;
    private final String gender;
    private final String status;

    private UserCreateRequest(String name, String email, String gender,
                              String status){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public static UserCreateRequestBuilder builder() {
        return new UserCreateRequestBuilder();
    }


    public static class UserCreateRequestBuilder{
        private String name;
        private String email;
        private String gender;
        private String status;

        private UserCreateRequestBuilder(){}

        public UserCreateRequestBuilder withName(String name){
            this.name = name;
            return this;
        }

        public UserCreateRequestBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public UserCreateRequestBuilder withGender(String gender){
            this.gender = gender;
            return this;
        }

        public UserCreateRequestBuilder withStatus(String status){
            this.status = status;
            return this;
        }

        public UserCreateRequest build(){
            return new UserCreateRequest(this.name, this.email, this.gender,
                    this.status);
        }

    }
}

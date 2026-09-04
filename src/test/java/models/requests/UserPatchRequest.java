package models.requests;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import serialization.PatchFieldSerializer;

public class UserPatchRequest {
    private final PatchField<String> name;
    private final PatchField<String> email;
    private final PatchField<String> gender;
    private final PatchField<String> status;

    private UserPatchRequest(
            PatchField<String> name,
            PatchField<String> email,
            PatchField<String> gender,
            PatchField<String> status) {

        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonSerialize(using = PatchFieldSerializer.class)
    public PatchField<String> getName() {
        return name;
    }
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonSerialize(using = PatchFieldSerializer.class)
    public PatchField<String> getEmail() {
        return email;
    }
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonSerialize(using = PatchFieldSerializer.class)
    public PatchField<String> getGender() {
        return gender;
    }
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonSerialize(using = PatchFieldSerializer.class)
    public PatchField<String> getStatus() {
        return status;
    }

    public static UserPatchRequestBuilder builder() {
        return new UserPatchRequestBuilder();
    }

    public static class UserPatchRequestBuilder {

        private PatchField<String> name = PatchField.unset();
        private PatchField<String> email = PatchField.unset();
        private PatchField<String> gender = PatchField.unset();
        private PatchField<String> status = PatchField.unset();

        private UserPatchRequestBuilder() {
        }

        public UserPatchRequestBuilder withName(String name) {
            this.name = PatchField.of(name);
            return this;
        }

        public UserPatchRequestBuilder withEmail(String email) {
            this.email = PatchField.of(email);
            return this;
        }

        public UserPatchRequestBuilder withGender(String gender) {
            this.gender = PatchField.of(gender);
            return this;
        }

        public UserPatchRequestBuilder withStatus(String status) {
            this.status = PatchField.of(status);
            return this;
        }

        public UserPatchRequestBuilder withoutName() {
            this.name = PatchField.unset();
            return this;
        }

        public UserPatchRequestBuilder withoutEmail() {
            this.email = PatchField.unset();
            return this;
        }

        public UserPatchRequestBuilder withoutGender() {
            this.gender = PatchField.unset();
            return this;
        }

        public UserPatchRequestBuilder withoutStatus() {
            this.status = PatchField.unset();
            return this;
        }

        public UserPatchRequest build() {
            return new UserPatchRequest(name, email, gender, status);
        }
    }

    public static class PatchField<T> {

        private final boolean defined;
        private final T value;

        private PatchField(boolean defined, T value) {
            this.defined = defined;
            this.value = value;
        }

        public static <T> PatchField<T> unset() {
            return new PatchField<>(false, null);
        }

        public static <T> PatchField<T> of(T value) {
            return new PatchField<>(true, value);
        }

        public T getValue() {
            return value;
        }

        public boolean isDefined() {
            return defined;
        }
    }
}

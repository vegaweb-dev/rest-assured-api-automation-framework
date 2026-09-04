package testdata;

public class UserTestData {

    public static String validName(){
        return "testName";
    }
    public static String validEmail(){
        return "testName%s@example.com".formatted(System.currentTimeMillis());
    }
    public static String validGender(){
        return "male";
    }
    public static String validStatus(){
        return "active";
    }
}

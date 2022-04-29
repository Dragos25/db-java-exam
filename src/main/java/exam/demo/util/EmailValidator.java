package exam.demo.util;

public class EmailValidator {
    public static boolean validate(String email){
        //only checking if there is an @ to have an exception
        return email.contains("@");
    }
}

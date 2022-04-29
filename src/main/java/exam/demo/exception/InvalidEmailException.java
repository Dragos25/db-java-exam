package exam.demo.exception;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(){
        super("Invalid email format");
    }
}

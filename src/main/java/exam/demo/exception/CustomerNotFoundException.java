package exam.demo.exception;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(Integer id){
        super("Customer with id " + id+" does not exist");
    }
}

package exam.demo.exception;

public class PizzaNotInMenuException extends Exception{
    public PizzaNotInMenuException(String name){
        super("Pizza " + name + " does not exist in menu");
    }
}

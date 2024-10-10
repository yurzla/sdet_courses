package lesson02;
public class WrongLoginException extends Exception{
    public WrongLoginException(){
    }
    public WrongLoginException(String description){
        super(description);
    }
}

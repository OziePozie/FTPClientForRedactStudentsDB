package Exceptions;

public class IncorrectCredentialsException extends RuntimeException{
    public IncorrectCredentialsException(){
        System.out.println("Incorrect Login/Password");
    }
}

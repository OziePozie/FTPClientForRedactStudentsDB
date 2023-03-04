package Exceptions;

public class NotFileOnServerExceptions extends RuntimeException{
    public NotFileOnServerExceptions(){
        System.out.println("Server not contains students.json");
    }
    public NotFileOnServerExceptions(String message) {
        super(message);
    }
}

package Exceptions;

public class ServerOfflineException extends RuntimeException{
    public ServerOfflineException(){
        System.out.println("Maybe Server is Offline. Check for his status");
    }
}

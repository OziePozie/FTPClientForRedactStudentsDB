package Utilities;

import Exceptions.IncorrectCredentialsException;
import Exceptions.IncorrectHostException;
import Exceptions.NotFileOnServerExceptions;
import Exceptions.ServerOfflineException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.rmi.ServerError;
import java.util.Scanner;

public class Connection {

    private boolean first = true;
    private int connectionStatus;
    private final String ftpUrl;
    private final static Scanner SCANNER = new Scanner(System.in);
    private URL url;
    private URLConnection conn;
    public Connection(String[] strings){
        this.ftpUrl = String.format("ftp://" + strings[0] + ":" + strings[1] + "@" + strings[2] + "/%s","students.json;type=i");
    }


    public static String[] getCredentials(){

        String[] credentials = new String[3];

        System.out.println("login: ");

        String name = SCANNER.next();

        credentials[0] = name;

        System.out.println("password: ");

        String password = SCANNER.next();

        credentials[1] = password;

        System.out.println("host: ");

        String host = SCANNER.next();

        credentials[2] = host;

        return credentials;
    }
    public void connectToServer() throws IOException {

        try {
            url = new URL(ftpUrl);

            if (url.openConnection().getInputStream().available() != 0) {

                System.out.println("Connection Successfully");

                conn = url.openConnection();

                connectionStatus = 1;

            }
            else throw new UnknownHostException();

        } catch (UnknownHostException e){

            throw new IncorrectHostException();

        } catch (MalformedURLException e){
            
            throw new ServerOfflineException();

        }catch (IOException e) {

            if (e.getMessage().contains("students.json")) {


                throw new NotFileOnServerExceptions();

            }

            else if (e.getMessage().contains("refused")) {

                throw new ServerOfflineException();

            }
            else {

                throw new IncorrectCredentialsException();

            }

        }

    }

    public URLConnection open() throws IOException {

    conn = url.openConnection();

    if (first) {

        first = false;

        System.out.println("Connect with DB students successfully");

    }

    else System.out.println("Update DB successfully");

    return conn;

    }

    public int getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(int connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}

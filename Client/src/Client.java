
import Utilities.CommandHandler;
import Utilities.Connection;
import Utilities.DataHandler;

import java.io.*;


public class Client {

    private static final CommandHandler commandHandler= new CommandHandler();


    public static void main(String[] args) throws IOException {

        Connection connection = new Connection(Connection.getCredentials());

        connection.connectToServer();

        DataHandler dataHandler = new DataHandler(connection);

        dataHandler.getFile();

        commandHandler.commandExecuter();

    }


}

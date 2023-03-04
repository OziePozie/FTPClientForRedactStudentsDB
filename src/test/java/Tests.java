
import Exceptions.IncorrectCredentialsException;
import Exceptions.IncorrectHostException;
import Exceptions.ServerOfflineException;
import Utilities.Connection;
import Utilities.DataHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.InputMismatchException;

public class Tests {


    @Test
    public void connectWithCorrectData() throws IOException {
        Connection connection = new Connection(new String[]{"timur", "123", "localhost"});
        connection.connectToServer();
        Assert.assertEquals(connection.getConnectionStatus(),1);
    }

    @Test(expectedExceptions = IncorrectCredentialsException.class)
    public void invalidLogin() throws IOException, RuntimeException {
        Connection connection = new Connection(new String[]{"t", "123", "localhost"});
        connection.connectToServer();
    }

    @Test(expectedExceptions = IncorrectHostException.class)
    public void invalidHost() throws IOException, RuntimeException {
        Connection connection = new Connection(new String[]{"timur", "123", "l"});
        connection.connectToServer();
    }

    /**
     *
     * Так как проверить работоспособность системы при отключении сервера можно только подключившись к несуществующему
     * хосту, то система будет выдавать IncorrectHostException, хотя на деле должно ServerOfflineException.
     *
     */
    @Test(expectedExceptions = IncorrectHostException.class)
    public void offlineServerOnSaveFile() throws IOException, RuntimeException {

        Connection connection = new Connection(new String[]{"timur", "123", "localhost"});

        connection.connectToServer();

        DataHandler dataHandler = new DataHandler(connection);

        dataHandler.getFile();

        Connection connection1 = new Connection(new String[]{"timur", "123", "NotExistHost"});

        dataHandler = new DataHandler(connection1);

        connection1.connectToServer();

        dataHandler.saveFile();


    }

    @Test(expectedExceptions = InputMismatchException.class)
    public void testCommandInput() throws IOException {

        CommandHandler commandHandler = new CommandHandler();

        Assert.assertThrows(commandHandler.commandExecuterForTests("fdsf"));


    }
    @Test(expectedExceptions = InputMismatchException.class)
    public void testCommandInput1() throws IOException {

        CommandHandler commandHandler = new CommandHandler();

        Assert.assertThrows(commandHandler.commandExecuterForTests("6"));

    }

}

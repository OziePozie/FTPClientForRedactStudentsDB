package Commands;

import Exceptions.ServerOfflineException;
import Utilities.DataHandler;
import Utilities.ParseJSON;
import Utilities.Student;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

public class AddCommand {
    private static final DataHandler dataHandler = new DataHandler();
    public void execute(String name, List<Student> studentList) {


        try {
            if (name.matches("\\W*")) {
                throw new IOException();
            }  else {
                ParseJSON.setFinalID(+1);
                studentList.add(new Student( "\"" + name + "\"", ParseJSON.getFinalID()));
                dataHandler.saveFile();
            }
        } catch (ConnectException e){

            throw new ServerOfflineException();

        } catch (IOException e){

            System.out.println("Name cant contain non-word characters");
        }


    }

}

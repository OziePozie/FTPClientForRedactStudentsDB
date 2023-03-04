package Utilities;

import Exceptions.ServerOfflineException;

import java.io.*;
import java.net.UnknownHostException;

public class DataHandler {
    private static Connection connection;

    private static final int BUFFER_SIZE = 4096;
    private static final ParseJSON parseJSON = new ParseJSON();

    public DataHandler(Connection c){
        connection = c;
    }
    public DataHandler(){

    }
    public void getFile() throws IOException {

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.open().getInputStream()));
        parseJSON.setStudentList(in);
        in.close();

    }
    public void saveFile() throws IOException {

        String fileName = "students.json";

        try {

            OutputStream outputStream = connection.open().getOutputStream();

            try(FileWriter writer = new FileWriter(fileName)) {

                StringBuilder str = new StringBuilder("{ \n \"students\": [");

                for (Student s: parseJSON.getStudentList()) {

                    if(parseJSON.getStudentList().indexOf(s) == parseJSON.getStudentList().size()-1)

                        str.append(s.toJSON().replace("},","}"));

                    else str.append(s.toJSON());

                }

                str.append("\n  ]\n}");

                writer.write(str.toString());

            }
            try (FileInputStream inputStream = new FileInputStream(fileName)) {

                byte[] buffer = new byte[BUFFER_SIZE];

                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {

                    outputStream.write(buffer, 0, bytesRead);

                }
            }
            /* Удаление файла с ДБ с ПК клиента */
            File f = new File(fileName);

            if (f.exists()) f.deleteOnExit();

            outputStream.close();

        } catch (UnknownHostException e) {

            System.out.println("Server offline");

            throw new ServerOfflineException();

        }

    }

}

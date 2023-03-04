package Commands;

import Utilities.DataHandler;
import Utilities.Student;

import java.io.IOException;
import java.util.List;

public class RemoveCommand {
    private static final DataHandler dataHandler = new DataHandler();
    public void execute(int id, List<Student> studentList) throws IOException {

        int i = (int) studentList.stream().filter(student -> student.getId() == id).count();

            try {

                if (i == 1) {

                    System.out.print("Delete student: ");

                    studentList.stream().filter(student -> student.getId() == id)
                            .forEach(System.out::println);

                    studentList.removeIf(student -> student.getId() == id);

                    dataHandler.saveFile();

                } else throw new Exception();

            } catch (Exception e){

                System.out.println("Student with this ID not exists");
            }
    }
}



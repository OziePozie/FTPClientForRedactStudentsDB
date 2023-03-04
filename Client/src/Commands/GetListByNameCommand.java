package Commands;

import Utilities.Student;

import java.util.List;
import java.util.stream.Collectors;

public class GetListByNameCommand {
    public void execute(List<Student> studentList){

        try {
            if (studentList.isEmpty()) throw new Exception();
            List<Student> students = studentList.stream().sorted().collect(Collectors.toList());
            int i = 1;
            for (Student student : students)
                System.out.println(i++ + ". " + student.getName().replace("\"",""));
        } catch (Exception e) {
            System.out.println("DB size is null");
        }


    }
}

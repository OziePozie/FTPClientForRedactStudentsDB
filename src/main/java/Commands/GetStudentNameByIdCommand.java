package Commands;

import Utilities.Student;

import java.util.List;

public class GetStudentNameByIdCommand {
    public void execute(int id, List<Student> studentList) {
        int i = (int) studentList.stream().filter(student -> student.getId() == id).count();
        if (i == 1) {
            for (Student student : studentList) {
                if (student.getId() == id) {
                    System.out.println("Имя: " + student.getName().replace("\"",""));
                }
            }
        }
        else System.out.println("Студента с таким ID не существует");
    }

}

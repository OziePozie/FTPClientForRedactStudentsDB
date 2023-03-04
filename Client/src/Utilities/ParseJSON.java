package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJSON {
    public static List<Student> studentList = new ArrayList<>();
    public static int finalID = 0;
    public void setStudentList(BufferedReader in) throws IOException {

        int id = 0;

        String inputLine;

        while ((inputLine = in.readLine()) != null) {

            String getValue = inputLine.substring(inputLine.indexOf(":") + 2);

            if (inputLine.contains("id")) {

                id = Integer.parseInt(getValue.replace(",", "").trim());

                finalID = check(finalID,id);
            }
            if (inputLine.contains("name")) {

                Student student = new Student(getValue, id);

                studentList.add(student);
            }
        }
    }
    public List<Student> getStudentList(){
        return studentList;
    }

    public static int getFinalID() {
        return finalID;
    }
    public static void setFinalID(int var){
        finalID = finalID + var;
    }
    public int check(int a, int b){

        if (a > b) return a;

        else return b;

    }
}

package Utilities;

public class Student implements Comparable<Student>{
    String name;
    int id;
    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }
    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String toJSON() {
        return "\n  \t{\n \t\"id\": " + this.id + ", \n  \t\"name\": " + this.name + "\n\t},";
    }

    @Override
    public String toString() {
        return "ID=" + this.id + " Name:" + this.name.replace("\"","");
    }

    @Override
    public int compareTo(Student o) {
       return Integer.compare(this.name.compareTo(o.name), 0);
    }

}

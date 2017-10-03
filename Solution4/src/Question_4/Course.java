package Question_4;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;

public class Course {
    private String title;
    private ArrayList<Student> students;
    private int numberOfStudent;

    public Course(String title) {
        this.title = title;
        students = new ArrayList<Student>();
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }

    public void registerStudent(Student student){
        if(!this.isFull()) {
            this.students.add(student);
            System.out.println(String.format("Student (name --- [%s] id --- [%s]) is successfully be added to [%s] course....." , student.getName(), student.getId(), this.title));
            //get the value of number of registered students
            this.numberOfStudent = this.students.size();
        }
        else
            System.out.println(String.format("Student (name --- [%s] id --- [%s]) cannot be added to [%s] course....." , student.getName(), student.getId(), this.title));
    }

    public boolean isFull(){

        if(this.numberOfStudent >= 10) {
            System.out.println("This class is already FULL!!!");
            return true;
        }
        else
            return false;
    }


}

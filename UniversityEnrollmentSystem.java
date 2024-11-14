import java.util.ArrayList;
import java.util.List;
class Student{
    private String name;
    private String studentID;
    public Student(String name, String studentID){
        this.name = name;
        this.studentID = studentID;
    }
    public String getName(){
        return name;
    }
    public String getStudentID(){
        return studentID;
    }
}
class Faculty{
    private String name;
    public Faculty(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class Syllabus{
    private String description;
    public Syllabus(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
class Course{
    private String courseName;
    private Faculty faculty;
    private List<Student> enrolledStudents;
    private Syllabus syllabus;
    public Course(String courseName, Faculty faculty, Syllabus syllabus){
        this.courseName = courseName;
        this.faculty = faculty;
        this.syllabus = syllabus;
        this.enrolledStudents = new ArrayList<>();
    }
    public void enrollStudent(Student student){
        enrolledStudents.add(student);
        System.out.println("Enrolled: " + student.getName());
    }
    public void enrollStudent(String studentID){
        System.out.println("Enrolling student with ID: " + studentID);
    }
    public String getCourseName(){
        return courseName;
    }
    public List<Student> getEnrolledStudents(){
        return enrolledStudents;
    }
    public Syllabus getSyllabus(){
        return syllabus;
    }
}
public class UniversityEnrollmentSystem{
    public static void main(String[] args){
        // Create faculty
        Faculty f = new Faculty("Professor Kumar");
        // Create syllabus
        Syllabus s = new Syllabus("Computer Programming");
        // Create course
        Course c = new Course("Programming", f, s);
        // Create students
        Student s1 = new Student("Arjun", "STU001");
        // Student student2 = new Student("Priya", "STU002");
        // Enroll students
        c.enrollStudent(s1);
        c.enrollStudent("STU001");
        // Display course info
        System.out.println("Course: " + c.getCourseName());
        System.out.println("Syllabus: " + c.getSyllabus().getDescription());
        System.out.println("Enrolled students:");
        for (Student student : c.getEnrolledStudents()){
            System.out.println("- " + student.getName());
        }
    }
}

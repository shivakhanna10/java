import java.util.*;
class Student {
    // Static final variables to define grade thresholds
    public static final int GRADE_A_THRESHOLD = 90;
    public static final int GRADE_B_THRESHOLD = 80;
    public static final int GRADE_C_THRESHOLD = 70;
    public static final int GRADE_D_THRESHOLD = 60;
    private String name;
    private int id;
    private int[] grades;
    private int numberOfSubjects;
    // Constructor to initialize student name, ID, and number of subjects
    public Student(String name, int id, int numberOfSubjects) {
        this.name = name;
        this.id = id;
        this.numberOfSubjects = numberOfSubjects;
        this.grades = new int[numberOfSubjects]; // Fixed size array for grades
    }
    // Method to add grades for the student
    public void addGrades(int[] gradesInput) {
        if (gradesInput.length == numberOfSubjects) {
            for (int i = 0; i < numberOfSubjects; i++) {
                grades[i] = gradesInput[i];
            }
        } else {
            System.out.println("Error: Number of grades must match the number of subjects.");
        }
    }
    // Method to calculate the average grade
    public double calculateAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numberOfSubjects; i++) {
            sum += grades[i];
        }
        return (double) sum / numberOfSubjects;
    }
    // Method to determine the overall grade based on the average
    public char calculateOverallGrade() {
        double average = calculateAverageGrade();
        if (average >= GRADE_A_THRESHOLD) {
            return 'A';
        } else if (average >= GRADE_B_THRESHOLD) {            return 'B';
        } else if (average >= GRADE_C_THRESHOLD) {
            return 'C';
        } else if (average >= GRADE_D_THRESHOLD) {
            return 'D';
        } else {
            return 'F';
        }
    }
    // Method to display the student's grades and overall performance
    public void displayGradesAndPerformance() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.print("Grades: ");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
        System.out.println("Average Grade: " + calculateAverageGrade());
        System.out.println("Overall Grade: " + calculateOverallGrade());
    }
}
public class StudentGradingSystem {
    public static void main(String[] args) {
        // Create a student with a fixed number of subjects (e.g., 3 subjects)
        Student student1 = new Student("khanna", 101, 3);
        // Add grades for the student
        int[] gradesInput = {85, 92, 78}; // Example grades for 3 subjects
        student1.addGrades(gradesInput);
        // Display the student's grades and overall performance
        student1.displayGradesAndPerformance();
    }
}

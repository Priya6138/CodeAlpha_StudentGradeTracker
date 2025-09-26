import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeTracker {

    private ArrayList<Integer> grades = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("--- Student Grade Tracker ---");
        
        inputGrades();
        
        if (grades.isEmpty()) {
            System.out.println("No grades entered. Exiting program.");
            return;
        }

        System.out.println("\n--- Grade Summary & Analysis ---");
        System.out.printf("Average Score: %.2f\n", calculateAverage());
        System.out.println("Highest Score: " + findHighest());
        System.out.println("Lowest Score: " + findLowest());

        displayReport();
        
        scanner.close();
    }

    private void inputGrades() {
        System.out.println("Enter student grades (0-100). Type 'done' to finish.");
        
        while (true) {
            System.out.print("Enter grade: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int grade = Integer.parseInt(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Invalid input. Grade must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'done'.");
            }
        }
    }

    private double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    private int findHighest() {
        return Collections.max(grades);
    }

    private int findLowest() {
        return Collections.min(grades);
    }

    private void displayReport() {
        System.out.println("\n--- Detailed Grade Report ---");
        for (int i = 0; i < grades.size(); i++) {
            System.out.println("Student " + (i + 1) + ": " + grades.get(i));
        }
        System.out.println("Total Students Processed: " + grades.size());
    }

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.start();
    }
}
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        
        // Arrays to store subject names and grades
        String[] subjects = new String[numberOfSubjects];
        double[] grades = new double[numberOfSubjects];
        
        // Input for subject names and grades
        for (int i = 0; i < numberOfSubjects; i++) {
            scanner.nextLine(); // Consume newline left-over
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();
            
            System.out.print("Enter the grade for " + subjects[i] + ": ");
            grades[i] = scanner.nextDouble();
        }
        
        // Calculate average grade
        double average = calculateAverage(grades);
        String letterGrade = getLetterGrade(average);
        
        // Display results
        System.out.println("\nGrades Summary:");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println(subjects[i] + ": " + grades[i]);
        }
        
        System.out.println("\nAverage Grade: " + average);
        System.out.println("Letter Grade: " + letterGrade);
        
        scanner.close();
    }

    // Method to calculate average grade
    public static double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Method to determine letter grade based on average
    public static String getLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

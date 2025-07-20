// Student Grade Tracker - Java Console Project

import java.util.*;

public class GradeTracker {
    static Scanner scanner = new Scanner(System.in);

    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n📚 Student Grade Tracker Menu");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Calculate Stats");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> calculateStats();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter grade (0-100): ");
        int grade = scanner.nextInt();
        scanner.nextLine();
        students.add(new Student(name, grade));
        System.out.println("✅ Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n📋 Student List:");
        for (Student s : students) {
            System.out.println("- " + s.name + ": " + s.grade);
        }
    }

    static void calculateStats() {
        if (students.isEmpty()) {
            System.out.println("No data to calculate.");
            return;
        }

        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) highest = s.grade;
            if (s.grade < lowest) lowest = s.grade;
        }

        double average = (double) total / students.size();
        System.out.println("\n📊 Grade Statistics:");
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }
}

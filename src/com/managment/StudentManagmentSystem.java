package com.managment;

import java.util.*;

public class StudentManagmentSystem {

    static class Student {
        private String name;
        private int rollNumber;
        private String grade;

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return "Student [Name=" + name + ", Roll Number=" + rollNumber + ", Grade=" + grade + "]";
        }
    }

    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        int choice;
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addStudentMenu();
                    break;
                case 2:
                    removeStudentMenu();
                    break;
                case 3:
                    searchStudentMenu();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudentMenu() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();
        addStudent(name, rollNumber, grade);
    }

    private static void addStudent(String name, int rollNumber, String grade) {
        Student student = new Student(name, rollNumber, grade);
        students.add(student);
    }

    private static void removeStudentMenu() {
        System.out.print("Enter Roll Number to remove: ");
        int rollNumber = scanner.nextInt();
        if (removeStudent(rollNumber)) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static boolean removeStudent(int rollNumber) {
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
            Student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    private static void searchStudentMenu() {
        System.out.print("Enter Roll Number to search: ");
        int rollNumber = scanner.nextInt();
        Student student = searchStudent(rollNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
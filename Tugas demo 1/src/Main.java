import java.util.Scanner;

public class Main {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final int MAX_NIM_LENGTH = 15;
    private static String[] bookList = {
            "1001, Java Programming, Heru, 5",
            "1002, Data Structures, Santosa, 10",
            "1003, Operating Systems, Dewi, 8"
    };
    private static Student[] userStudent = new Student[10];
    private static Admin admin = new Admin();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Library System");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.println("=====");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM: ");
                    String nim = scanner.next();
                    if (nim.length() == MAX_NIM_LENGTH) {
                        Student student = checkNim(nim);
                        if (student != null) {
                            student.menuStudent();
                        } else {
                            System.out.println("Student not found");
                        }
                    } else {
                        System.out.println("Invalid NIM");
                    }
                    break;
                case 2:
                    System.out.print("Enter your username (admin): ");
                    String username = scanner.next();
                    System.out.print("Enter your password (admin): ");
                    String password = scanner.next();
                    if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                        admin.menuAdmin();
                    } else {
                        System.out.println("Admin User Not Found");
                    }
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println();
        }

        System.out.println("Adios");
    }

    public static Student checkNim(String nim) {
        for (Student student : userStudent) {
            if (student != null && student.getNim().equals(nim)) {
                return student;
            }
        }
        return null;
    }
}

class Student {
    private String nim;
    private String name;
    private String faculty;
    private String studyProgram;

    public Student() {
    }

    public void menuStudent() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Student Dashboard");
            System.out.println("1. Display Books");
            System.out.println("2. Logout");
            System.out.println("=====");
            System.out.print("Choose option (1-2): ");
            int choice = Main.scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println();
        }
    }

    public void displayBooks() {
        System.out.println("List of Books:");
        for (String book : Main.bookList) {
            String[] data = book.split(", ");
            System.out.println("ID: " + data[0] + ", Title: " + data[1] + ", Author: " + data[2] + ", Stock: " + data[3]);
        }
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }
}

class Admin {
    public void menuAdmin() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Admin Dashboard");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Logout");
            System.out.println("=====");
            System.out.print("Choose option (1-3): ");
            int choice = Main.scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println();
        }
    }

    public void addStudent() {
        Student student = new Student();
        Main.inputNim(student);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        student.setName(scanner.next());
        System.out.print("Enter your faculty: ");
        student.setFaculty(scanner.next());
        System.out.print("Enter your study program: ");
        student.setStudyProgram(scanner.next());
        for (int i = 0; i < Main.userStudent.length; i++) {
            if (Main.userStudent[i] == null) {
                Main.userStudent[i] = student;
                System.out.println("Student added successfully");
                break;
            }
        }
    }

    public void displayStudents() {
        System.out.println("List of Students:");
        for (Student student : Main.userStudent) {
            if (student != null) {
                System.out.println("NIM: " + student.getNim() + ", Name: " + student.getName() + ", Faculty: " + student.getFaculty() + ", Study Program: " + student.getStudyProgram());
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));

        System.out.println("Student Added Successfully.");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Student Found.");
            return;
        }

        for (Student s : students) {
            System.out.println("--------------------");
            System.out.println(s);
        }
    }

    static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.getId() == id) {

                System.out.print("New Name: ");
                s.setName(sc.nextLine());

                System.out.print("New Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();

                System.out.print("New Course: ");
                s.setCourse(sc.nextLine());

                System.out.println("Updated Successfully.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Deleted Successfully.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }
}

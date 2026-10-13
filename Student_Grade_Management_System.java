import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }

    public String toString() {
        return id + "\t" + name + "\t" + marks
                + "\t" + getGrade();
    }
}

public class Student_Grade_Management_System {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        HashSet<Integer> studentIds = new HashSet<>();
        HashMap<Integer, Integer> marksMap = new HashMap<>();
        Queue<Integer> processingQueue = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n--- STUDENT GRADE MANAGEMENT ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Process Student Grades");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    if (studentIds.contains(id)) {
                        System.out.println(
                            "Error: Student ID already exists!"
                        );
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks (0-100): ");
                    int marks = sc.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    Student s = new Student(id, name, marks);

                    students.add(s);
                    studentIds.add(id);
                    marksMap.put(id, marks);
                    processingQueue.add(id);

                    System.out.println(
                        "Student added successfully!"
                    );
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records.");
                    } else {
                        System.out.println(
                            "\nID\tName\tMarks\tGrade"
                        );

                        for (Student st : students) {
                            System.out.println(st);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    if (marksMap.containsKey(searchId)) {
                        for (Student st : students) {
                            if (st.id == searchId) {
                                System.out.println(
                                    "Student Details: " + st
                                );
                                break;
                            }
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    if (processingQueue.isEmpty()) {
                        System.out.println(
                            "No students waiting for processing."
                        );
                    } else {
                        int processId = processingQueue.poll();

                        System.out.println(
                            "Processed Student ID: " + processId
                        );
                        System.out.println(
                            "Marks: " + marksMap.get(processId)
                        );
                    }
                    break;

                case 5:
                    System.out.println(
                        "Exiting Student Grade Management System."
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}


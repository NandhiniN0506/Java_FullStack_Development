import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int[] marks;
    int total;
    double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = Arrays.stream(marks).sum();
        this.average = total / (double) marks.length;
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(s.total, this.total);
    }
}

public class StudentMarksSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter number of subjects: ");
            int subjects = scanner.nextInt();
            int[] marks = new int[subjects];
            System.out.println("Enter marks: ");
            for (int j = 0; j < subjects; j++) {
                marks[j] = scanner.nextInt();
            }
            students[i] = new Student(name, marks);
        }
        scanner.close();

        Arrays.sort(students);
        System.out.println("\nSorted List of Students by Total Marks:");
        for (Student s : students) {
            System.out.println(s.name + " - Total: " + s.total + ", Average: " + s.average);
        }
    }
}

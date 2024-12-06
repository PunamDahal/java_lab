
class CSITStudent {
    String name;
    int rollNo;
    String course;

    CSITStudent(String name, int rollNo, String course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
    }

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Course: " + course);
    }
}

public class lab1{
    public static void main(String[] args) {
        CSITStudent student1 = new CSITStudent("Punam", 101, "Java Programming");
        CSITStudent student2 = new CSITStudent("Alice", 102, "Data Warehouse");

        System.out.println("=== Student 1 Details ===");
        student1.displayDetails();

        System.out.println("\n=== Student 2 Details ===");
        student2.displayDetails();
    }
}

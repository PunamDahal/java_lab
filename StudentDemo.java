public class StudentDemo {
    public static void main(String[] args) {
        Student s0 = new Student(1, "Ram Bahadur", "Kathmandu", "9841234674", new DOB(12, 23, 2024));
        // s0.displayInfo();
        System.out.println(s0);
    }
}

class Student {
    private int id;
    private String name;
    private String address;
    private String phone;
    private DOB dob;

    public Student() {

    }

    public Student(int id, String name, String address, String phone, DOB dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Id : " + id);
        System.out.println("Name : " + name);
        System.out.println("Address : " + address);
        System.out.println("Phone No : " + phone);
        System.out.println("Date Of Birth : " + dob.printDOB());

    }

    @Override
    public String toString() {
        return "Id : " + id + "\n" + "Name : " + name + "\n" + "Address : " + address + "\n" + "Phone No : " + phone
                + "\n" + "Date Of Birth : " + dob.printDOB();

    }

}

class DOB {
    int mm, dd, yy;

    public DOB(int mm, int dd, int yy) {
        this.mm = mm;
        this.dd = dd;
        this.yy = yy;
    }

    public String printDOB() {
        return dd + "/" + mm + "/" + yy;
    }
}
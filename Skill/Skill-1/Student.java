class Student {
    int st_Id;
    String name;
    int age;

    void displayDetails() {
        System.out.println("Student ID: " + st_Id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.st_Id = 101;
        s1.name = "Rahul";
        s1.age = 20;

        Student s2 = new Student();
        s2.st_Id = 102;
        s2.name = "Priya";
        s2.age = 19;

        Student s3 = new Student();
        s3.st_Id = 103;
        s3.name = "Arjun";
        s3.age = 21;

        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
    }
}
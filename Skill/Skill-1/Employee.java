class Employee {
    int employeeId;
    String name;
    double salary;

    Employee(int id, String n, double s) {
        employeeId = id;
        name = n;
        salary = s;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Rahul", 30000);
        Employee e2 = new Employee(102, "Priya", 40000);

        e1.displayDetails();
        System.out.println("-------------------");
        e2.displayDetails();
    }
}
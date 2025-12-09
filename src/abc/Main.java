package abc;
import java.util.Scanner;
class Employee {
    String name;
    int age;
    String designation;
    double salary;

    void create(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        switch (designation.toLowerCase()) {
            case "programmer":
                salary = 20000;
                break;
            case "manager":
                salary = 25000;
                break;
            case "tester":
                salary = 15000;
                break;
            default:
                salary = 0;
        }
    }

    void display() {
        if (name == null) {
            System.out.println("No employee created yet!");
            return;
        }

        System.out.println("----- Employee Details -----");
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Designation : " + designation);
        System.out.println("Salary      : " + salary);
    }

    void raiseSalary(double percent) {
        double increment = (salary * percent) / 100;
        salary += increment;
        System.out.println("Salary updated successfully!");
        display();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        int choice;
        while (true) {
            System.out.println("\n===== Employee Management =====");
            System.out.println("1. Create Employee");
            System.out.println("2. Display Details");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter Name (only 2 words): ");
                    String name = scanner.nextLine().trim();
                    String[] words = name.split("\\s+");
                    if (words.length > 2) {
                        System.out.println("Error: Name cannot exceed 2 words!");
                        break;
                    }
                    System.out.print("Enter Age (20-60): ");
                    int age = scanner.nextInt();
                    if (age < 20 || age > 60) {
                        System.out.println("Error: Age must be between 20 and 60!");
                        break;
                    }
                    scanner.nextLine(); 
                    System.out.print("Enter Designation (Programmer/Manager/Tester): ");
                    String designation = scanner.nextLine().trim();
                    if (!designation.equalsIgnoreCase("programmer")
                            && !designation.equalsIgnoreCase("manager")
                            && !designation.equalsIgnoreCase("tester")) {
                        System.out.println("Invalid designation!");
                        break;
                    }
                    employee.create(name, age, designation);
                    System.out.println("Employee created successfully!");
                    break;

                case 2:
                    employee.display();
                    break;

                case 3:
                    
                    if (employee.name == null) {
                        System.out.println("No employee found! Please create an employee first.");
                        break;
                    }

                    System.out.print("Enter Employee Name: ");
                    String searchName = scanner.nextLine().trim();

                    if (!searchName.equalsIgnoreCase(employee.name)) {
                        System.out.println("Employee not found!");
                        break;
                    }

                    System.out.print("Enter increment percent (1-10): ");
                    double percent = scanner.nextDouble();

                    if (percent < 1 || percent > 10) {
                        System.out.println("Invalid percent! Only 1 to 10 allowed.");
                        break;
                    }

                    employee.raiseSalary(percent);
                    break;

                case 4:
                    System.out.println("Thank you for using this application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

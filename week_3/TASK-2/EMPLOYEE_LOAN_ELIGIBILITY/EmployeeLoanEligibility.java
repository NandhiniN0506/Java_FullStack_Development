import java.util.Scanner;

// Employee class definition
class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsWorked;

    // Method to set employee details
    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    // Method to get employee details
    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Salary: " + sal);
        System.out.println("Years Worked: " + yearsWorked);
    }

    // Method to check loan eligibility
    public void getLoanEligibility() {
        if (yearsWorked <= 5) {
            System.out.println("Not eligible for loan (less than 5 years of service).\n");
            return;
        }

        double annualSalary = sal * 12;
        double loanAmount = 0;

        if (annualSalary >= 15_00_000) {
            loanAmount = 7_00_000;
        } else if (annualSalary >= 10_00_000) {
            loanAmount = 5_00_000;
        } else if (annualSalary >= 6_00_000) {
            loanAmount = 2_00_000;
        }

        if (loanAmount > 0) {
            System.out.println("Loan Granted: " + loanAmount);
        } else {
            System.out.println("Not eligible for loan.");
        }
    }
}

// Main class to test Employee class
public class EmployeeLoanEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();

        System.out.print("Enter Monthly Salary: ");
        double sal = scanner.nextDouble();

        System.out.print("Enter Years Worked: ");
        int yearsWorked = scanner.nextInt();

        // Creating Employee object and setting details
        Employee emp = new Employee();
        emp.setEmployeeDetails(empId, empName, sal, yearsWorked);

        // Displaying employee details
        System.out.println("\nEmployee Details:");
        emp.getEmployeeDetails();

        // Checking loan eligibility
        System.out.println("\nLoan Eligibility:");
        emp.getLoanEligibility();

        scanner.close();
    }
}

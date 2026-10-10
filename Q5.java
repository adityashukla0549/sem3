class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println("Company: " + companyName + " | Total Employees: " + employeeCount);
    }
}

public class Q5 {
    public static void main(String[] args) {
        CompanyEmployee e1 = new CompanyEmployee("Alice", 50000.0);
        CompanyEmployee e2 = new CompanyEmployee("Bob", 60000.0);
        CompanyEmployee e3 = new CompanyEmployee("Charlie", 55000.0);

        CompanyEmployee.printCompanyInfo();
    }
}
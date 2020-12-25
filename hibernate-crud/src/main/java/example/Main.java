package example;

import example.entities.Employee;
import example.services.EmployeeService;
import example.services.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        createEmployee(employeeService);
    }

    private static void createEmployee(EmployeeService employeeService) {
        employeeService.createEmployee(getEmployee());
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Carlos Eduardo");
        employee.setEmail("examplaea@email.com");
        employee.setSalary(5_040.00D);
        return employee;
    }
}

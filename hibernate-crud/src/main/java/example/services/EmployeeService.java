package example.services;

import example.entities.Employee;

public interface EmployeeService {
    void createEmployee(Employee employee);

    Employee getEmployerById(int employeeId);

    void updateEmployeeById(int employeeId, Employee employee);

    void deleteEmployeeById(int employeeId);
}

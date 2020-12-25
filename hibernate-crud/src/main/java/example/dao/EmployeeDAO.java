package example.dao;

import example.entities.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee fetchEmployerById(int employeeId);

    void updateEmployeeById(int employeeId, Employee employee);

    void deleteEmployeeById(int employeeId);
}

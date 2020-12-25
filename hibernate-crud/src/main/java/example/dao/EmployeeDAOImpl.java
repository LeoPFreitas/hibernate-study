package example.dao;

import example.entities.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {
        new EmployeeDAOImpl().addEmployee(employee);
    }

    @Override
    public Employee fetchEmployerById(int employeeId) {
        return new EmployeeDAOImpl().fetchEmployerById(employeeId);
    }

    @Override
    public void updateEmployeeById(int employeeId, Employee employee) {
        new EmployeeDAOImpl().updateEmployeeById(employeeId, employee);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        new EmployeeDAOImpl().deleteEmployeeById(employeeId);
    }
}

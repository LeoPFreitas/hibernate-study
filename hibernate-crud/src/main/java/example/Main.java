package example;

import example.entities.Employee;
import example.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            createEmployee(session);
            getEmployeeById(session, 2);
            getEmployeeById(session, 20);
            updateEmployeeById(session, 2);
            deleteEmployeeById(session, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployeeById(Session session, int id) {
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        } else {
            System.out.println("Employee does not exist with providaded ID: " + id);
        }
    }

    private static void updateEmployeeById(Session session, int id) {
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            employee.setSalary(30_000.00D);
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } else {
            System.out.println("Employee does not exist with providaded ID: " + id);
        }
    }

    private static void getEmployeeById(Session session, int id) {
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            System.out.println(employee.toString());
        } else {
            System.out.println("Employee does not exist with providaded ID: " + id);
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id = (Integer) session.save(createEmployee());
        System.out.println("Employee created with ID: " + id);
        session.getTransaction().commit();
    }

    private static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Carlos Eduardo");
        employee.setEmail("examplea@email.com");
        employee.setSalary(5_000.00D);
        return employee;
    }
}

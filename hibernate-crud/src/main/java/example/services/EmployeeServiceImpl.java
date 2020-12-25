package example.services;

import example.dao.EmployeeDAO;
import example.entities.Employee;
import example.util.HibernateUtil;
import org.hibernate.Session;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void createEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("Employee created with ID: " + id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployerById(int employeeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                System.out.println(employee.toString());
            } else {
                System.out.println("Employee does not exist with providaded ID: " + employeeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployeeById(int employeeId, Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (employee != null) {
                session.beginTransaction();
                session.update(employee);
                session.getTransaction().commit();
            } else {
                System.out.println("Employee does not exist with providaded ID: " + employeeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.beginTransaction();
                session.delete(employee);
                session.getTransaction().commit();
            } else {
                System.out.println("Employee does not exist with providaded ID: " + employeeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

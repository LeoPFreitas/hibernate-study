package example;

import example.entities.Employee;
import example.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, 3);
            if (employee != null) {
                /*
                 * DIRTY CHECKING
                 * Hibernate will update the employee entity if we change its state inside the session transaction boundary,
                 * even if we don't call update method. That is the concept of dirty checking.
                 * */
                session.beginTransaction();
                employee.setSalary(5_000_000.00D);
                employee.setEmployeeName("lalalasa");
                session.getTransaction().commit();
                employee.setSalary(5_001.00D);
            } else {
                System.out.println("Employee not founded!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Leonardo Freitas");
        employee.setEmail("example@email.com");
        employee.setSalary(25_000.00D);
        return employee;
    }
}

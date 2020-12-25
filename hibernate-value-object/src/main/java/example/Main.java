package example;

import example.entities.Address;
import example.entities.Employee;
import example.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(getEmployee());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Leonardo Freitas");
        employee.setEmail("example1@email.com");
        employee.setSalary(15_000.00D);

        Address address = new Address();
        address.setCep("05005001");
        address.setCityName("Sao Paulo");
        address.setStreetName("Rua nome da rua");
        address.setStateName("Sao Paulo");
        employee.setAddress(address);

        return employee;
    }

    private static Employee getEmployee2() {
        Employee employee = new Employee();
        employee.setEmployeeName("Leonardo Freitas 2");
        employee.setEmail("example2@email.com");
        employee.setSalary(15_000.00D);
        return employee;
    }

    private static Employee getEmployee3() {
        Employee employee = new Employee();
        employee.setEmployeeName("Leonardo Freitas 3");
        employee.setEmail("example3@email.com");
        employee.setSalary(15_000.00D);
        return employee;
    }
}

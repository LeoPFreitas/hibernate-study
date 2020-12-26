package example;

import example.entities.Address;
import example.entities.Employee;
import example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

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

        Address address1 = new Address();
        address1.setCep("05005001");
        address1.setCityName("Sao Paulo");
        address1.setStreetName("Rua nome da rua");
        address1.setStateName("Sao Paulo");

        Address address2 = new Address();
        address2.setCep("05322001");
        address2.setCityName("Sao Paulo");
        address2.setStreetName("Rua nome da rua");
        address2.setStateName("Sao Paulo");

        employee.getAddressList().addAll(List.of(address1, address2));

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

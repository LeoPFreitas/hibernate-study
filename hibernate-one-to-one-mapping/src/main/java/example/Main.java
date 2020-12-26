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

        employee.setAddress(address1);

        return employee;
    }
}

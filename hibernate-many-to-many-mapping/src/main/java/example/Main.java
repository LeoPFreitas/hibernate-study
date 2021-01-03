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

            Employee employee = new Employee();
            employee.setEmployeeName("Leonardo Freitas");
            employee.setEmail("example1@email.com");
            employee.setSalary(15_000.00D);

            Employee employee2 = new Employee();
            employee2.setEmployeeName("Leonardo Freitas 2");
            employee2.setEmail("example2@email.com");
            employee2.setSalary(25_000.00D);

            Employee employee3 = new Employee();
            employee3.setEmployeeName("Leonardo Freitas 3");
            employee3.setEmail("example3@email.com");
            employee3.setSalary(35_000.00D);

            Address address1 = new Address();
            address1.setCep("05005001");
            address1.setCityName("Sao Paulo");
            address1.setStreetName("Rua nome da rua");
            address1.setStateName("Sao Paulo");

            Address address2 = new Address();
            address2.setCep("05003201");
            address2.setCityName("Sao Paulo");
            address2.setStreetName("Rua nome da rua nova");
            address2.setStateName("Sao Paulo");

            session.persist(address1);
            session.persist(address2);

            employee.getAddressList().addAll(List.of(address1, address2));
            employee2.getAddressList().add(address2);
            employee3.getAddressList().add(address1);

            session.persist(employee);
            session.persist(employee2);
            session.persist(employee3);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

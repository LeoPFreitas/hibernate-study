package example;

import example.entities.Address;
import example.entities.Employee;
import example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            getEmployAndAddressByEMployeeId();

//            session.beginTransaction();
//            session.persist(getEmployee());
//            session.getTransaction().commit();
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
        address2.setCep("05003201");
        address2.setCityName("Sao Paulo");
        address2.setStreetName("Rua nome da rua nova");
        address2.setStateName("Sao Paulo");

        employee.getAddressList().addAll(List.of(address1, address2));

        address1.setEmployee(employee);
        address2.setEmployee(employee);

        return employee;
    }

    private static void getEmployAndAddressByEMployeeId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, 1);

            if (employee != null) {
                System.out.println(employee.toString());
                employee.getAddressList()
                        .forEach(e -> System.out.println(e.toString()));
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

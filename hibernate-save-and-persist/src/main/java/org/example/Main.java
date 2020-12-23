package org.example;

import org.example.entities.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            /*
             * persist() -> Save an entity into database and return void
             * It will throw an exception if the entity already exists in the database
             * */
            session.persist(getEmployee1());

            /*
             * save() -> Save the entity into database and return generated primary key
             * It will throw an exception if the entity already exists in the database
             * */
            Integer id = (Integer) session.save(getEmployee2());
            System.out.println("Employee created with ID: " + id);

            /*
             * saveOrUpdate() -> Save or update an entity into database
             * */
            session.saveOrUpdate(getEmployee3());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Employee getEmployee1() {
        Employee employee = new Employee();
        employee.setEmployeeName("Leonardo Freitas");
        employee.setEmail("example1@email.com");
        employee.setSalary(15_000.00D);
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

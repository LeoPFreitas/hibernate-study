package org.example;

import org.example.entities.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = getEmployee();

            session.beginTransaction();

            /*
             * Persist and save will throw an exception if the PK already exists
             * */

            // return the generated PK
            Integer id = (Integer) session.save(employee);

            // do not return the generated PK
//            session.persist(employee);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Leonardo Freitas");
        employee.setEmail("example@email.com");
        employee.setSalary(15_000.00D);
        return employee;
    }
}

package com.company.main;

import com.company.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT VERSION();";

            String result = (String) session.createNativeQuery(sql).getSingleResult();

            System.out.println("Postgres version is: ");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

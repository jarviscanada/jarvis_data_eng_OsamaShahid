package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

    public static void main (String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport", "postgres", "password");

        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);

            Customer customer = new Customer();

            customer.setFirstName("John");
            customer.setLastName("Adams");
            customer.setEmail("john@gmail.com");
            customer.setAddress("123 apple. st");
            customer.setCity("Arlington");
            customer.setState("VA");
            customer.setPhone("555 555 5555");
            customer.setZipCode("55325");

            Customer dbcustomer = customerDAO.create(customer);
            System.out.println(dbcustomer);
            dbcustomer = customerDAO.findById(dbcustomer.getId());
            System.out.println(dbcustomer);
            dbcustomer.setEmail("johnwhite@gmail.com");
            dbcustomer = customerDAO.update(dbcustomer);
            System.out.println(dbcustomer);
            customerDAO.delete(dbcustomer.getId());

            /*
            Customer customer = customerDAO.findById(10000);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
                    customer.getEmail());
            customer.setEmail("gwashtion@gmail.com");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
                    customer.getEmail());*/

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

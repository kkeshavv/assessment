package com.capg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    public void save(Employee emp) {

        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/springmvcdb",
                    "postgres",
                    "1230");   // your postgres password

            String query = "insert into employee(id, name, phone, email) values (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setLong(3, emp.getPhone());
            ps.setString(4, emp.getEmail());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
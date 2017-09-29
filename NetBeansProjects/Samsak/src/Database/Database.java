/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Kurniawan
 */
import java.sql.*;

public class Database {

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/university [univ on UNIV]", "univ", "univ");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM UNIV.CLASS");

            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                int sks = rs.getInt("SKS");
                System.out.println(id + "   " + name+"  "+sks);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

}

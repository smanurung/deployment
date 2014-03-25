/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sonny
 */
class ConnectionManager {

    static Connection con;
    static String url;

    public static Connection getConnection() {

        try {
            String url = "jdbc:mysql://localhost:3306/" + "secureDB";
            // assuming "DataSource" is your DataSource name

            Class.forName("com.mysql.jdbc.Driver");

            try {
                con = DriverManager.getConnection(url, "user", "password");

            // assuming your SQL Server's	username is "username"               
                // and password is "password"
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}

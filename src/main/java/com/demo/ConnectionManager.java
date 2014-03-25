/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.URISyntaxException;
import java.net.URI;

/**
 *
 * @author sonny
 */
class ConnectionManager {

    static Connection con;
    static String url;

    public static Connection getConnection() throws URISyntaxException, SQLException {

		/*
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
		*/
		
		/*
		URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		
		String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		*/
		
		String username = "b8a6c9d88f5ea1";
		String password = "09e826a2";
		String dbUrl = "jdbc:mysql://us-cdbr-east-05.cleardb.net:3306/heroku_4929761f021afce";

		return DriverManager.getConnection(dbUrl, username, password);
    }
}

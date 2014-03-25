/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sonny
 */
public class UserDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static UserBean login(UserBean bean) {

        //preparing some objects for connection 
        PreparedStatement prepStmt = null;

        String username = bean.getUsername();
        String password = bean.getPassword();
        
        String searchQuery = "SELECT * FROM user WHERE username=? AND password=?";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try {
//            connect to DB 
            currentCon = ConnectionManager.getConnection();
            
            prepStmt = currentCon.prepareStatement(searchQuery);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);
            rs = prepStmt.executeQuery();
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                bean.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");

                System.out.println("Welcome " + firstName);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setValid(true);
            }
        } catch (Exception ex) {
            System.out.println("Login failed: an exception has occurred! " + ex);
        } //some exception handling
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    // TODO Exception handling
                }
                rs = null;
            }

            if (prepStmt != null) {
                try {
                    prepStmt.close();
                } catch (Exception e) {
                    // TODO Exception handling
                }
                prepStmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                    // TODO Exception handling
                }

                currentCon = null;
            }
        }

        return bean;

    }

    public static String passwordIfInDB(String username) {
        
        String obtainedPassword = null;
        PreparedStatement prepStmt = null;

        String searchQuery = "SELECT password FROM user WHERE username=?";

        try {
            currentCon = ConnectionManager.getConnection();

            prepStmt = currentCon.prepareStatement(searchQuery);
            prepStmt.setString(1, username);
            rs = prepStmt.executeQuery();
            boolean exist = rs.next();

            if (exist) {
                obtainedPassword = rs.getString("password");
            } else {
                obtainedPassword = null;
            }

        } catch (Exception  ex) {
            System.out.println("Finding username failed: " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    // TODO Exception handling
                }
                rs = null;
            }

            if (prepStmt != null) {
                try {
                    prepStmt.close();
                } catch (Exception e) {
                    // TODO Exception handling
                }
                prepStmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                    // TODO Exception handling
                }

                currentCon = null;
            }
        }

        return obtainedPassword;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sonny
 */
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserBean user = new UserBean();
            user.setUserName(request.getParameter("un"));
            user.setPassword(request.getParameter("pw"));

            user = UserDAO.login(user);                        
            
            HttpSession session = request.getSession();
            int attempt = (Integer) session.getAttribute("attempt");
            
            if (attempt < 3) {
              if (user.isValid()) {                  
                  session.setAttribute("currentSessionUser", user);
                  session.setAttribute("logged", "success");
                  session.setAttribute("attempt", 0);
                  response.sendRedirect("userLogged.jsp"); //logged-in page                             
              } else {
                  attempt++;
                  session.setAttribute("attempt", attempt);
                  session.setAttribute("logged", "fail");
                  response.sendRedirect("invalidLogin.jsp"); //error page 
              }
            } else {
              response.sendRedirect("login-captcha.jsp");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
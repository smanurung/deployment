/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author damiann
 */
public class FormServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
      String str = request.getParameter("str");
      String regex = new String("^\\w");
      
      if(!str.matches(regex)) {
        str = encode(str);        
      }
      
      if (str != null) {
        try {
          HttpSession session = request.getSession();
          session.setAttribute("str", str);
          response.sendRedirect("showString.jsp");
        } catch (IOException ex) {
          Logger.getLogger(FormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      }     
    }
    
    private String encode(String str) {
      if (str == null) return null;
        StringBuffer s = new StringBuffer();
        for (short i = 0; i < str.length(); i++) {
          char c = str.charAt(i); switch (c) {
            case '<': s.append("&lt;");break;
            case '>': s.append("&gt;");break;
            case '(': s.append("&#40;");break;
            case ')': s.append("&#41;");break;
            case '#': s.append("&#35;");break;
            case '&': s.append("&amp;");break;
            case '"': s.append("&quot;");break;
            case '\'': s.append("&apos;");break;
            case '%': s.append("&#37;");break;
            case '+': s.append("&#43;");break;
            case '-': s.append("&#45;");break;
            default: s.append(c);          
          } 
        }
        return s.toString(); 
    }
}

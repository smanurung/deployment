/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo;

/**
 *
 * @author damiann
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForgotPasswordServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String obtainedPassword = null;
        String username = request.getParameter("un");

        obtainedPassword = UserDAO.passwordIfInDB(username);

        if (obtainedPassword != null) {
            String [] credentials = null;

            BufferedReader br = null;
            try {
                String sCurrentLine;
                br = new BufferedReader(new FileReader("src/main/java/com/demo/credentials.conf"));
                int i = 0;
                while ((sCurrentLine = br.readLine()) != null) {
                    credentials[i] = sCurrentLine;
                    i += 1;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null)br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
            final String sendername = credentials[0];
            final String senderpass = credentials[1];

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sendername, senderpass);
                }
            });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(senderpass));
                message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(username));
                message.setSubject("Your Forgotten Password Request, " + username);
                message.setText("I hope you would never get lost again" +
                    "\n\n Here's your Password, " + obtainedPassword);

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendRedirect("ForgotFail.jsp");
        }

    }
}
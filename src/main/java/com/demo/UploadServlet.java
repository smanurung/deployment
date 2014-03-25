/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author sonny
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB
                 maxFileSize=1024*1024*50,          // 50 MB
                 maxRequestSize=1024*1024*100,      // 100 MB
                 location="/home/sonny/Documents/KPI/Tugas I/IF4033-14/SecureWebProject/uploads")
public class UploadServlet extends HttpServlet {    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {        
        String filename = null;
        for(Part part : request.getParts())
        {
            filename = getFileName(part);
            part.write(filename);
        }
        
        request.setAttribute("message", filename+" file has been upload successfully");
        getServletContext().getRequestDispatcher("/uploadsuccess.jsp").forward(request, response);
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for(String token : tokens)
        {
            if(token.trim().startsWith("filename"))
            {
                return token.substring(token.indexOf("=")+2, token.length()-1);
            }
        }
        return "";
    }
}

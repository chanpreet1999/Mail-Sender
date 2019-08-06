/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chanpreet
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
         PrintWriter out =response.getWriter();
         
         String uname=request.getParameter("uname");
         String pass=request.getParameter("pass");
         String subject=request.getParameter("subject");
         String to=request.getParameter("to");
         String message=request.getParameter("message");
         
         SendMail.send(to,subject,message,uname,pass);
         
         out.println("Email sent successfully");
    }

}

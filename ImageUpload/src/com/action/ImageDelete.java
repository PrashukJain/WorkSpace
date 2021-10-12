package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.UtilityConfiguration;

@WebServlet("/ImageDelete")
public class ImageDelete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
       
        
        String ImageId=request.getParameter("imageid").toString();
        
        try(Session session=new UtilityConfiguration().getSession()){
            Transaction tx = session.beginTransaction();
            session.createQuery("delete from ImageDetails where Image_ID= :ImageId").setString("ImageId", ImageId)
                    .executeUpdate();
            tx.commit();
            response.sendRedirect("imageManagement.jsp");

        }catch(Exception e) {
            e.printStackTrace();

        }
}
}

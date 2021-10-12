package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.classes.User;

import configuration.UtilityConfiguration;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        Session session = new UtilityConfiguration().getSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        User datauser = session.get(User.class, name);

        System.out.println(datauser.getPassword());
        if (datauser.getPassword().equals(password)) {
            javax.servlet.http.HttpSession httpsession = request.getSession();
            httpsession.setAttribute("user", datauser);
            tx.commit();
            request.getRequestDispatcher("imageManagement.jsp").forward(request, response);

        } else {
            tx.commit();
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }


    }

}

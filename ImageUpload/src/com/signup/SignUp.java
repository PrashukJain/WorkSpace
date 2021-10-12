package com.signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.classes.User;

import configuration.UtilityConfiguration;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        System.out.println("In signup servlet");
        String name = request.getParameter("userName");
        String password = request.getParameter("password");

        if (name == null || name.equals("") || password == null || password.equals("")) {
            String msg = "Invalid UserName and Password";
            request.setAttribute("msg", msg);
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
        } else {
            Session session = new UtilityConfiguration().getSession();
            Transaction tx = session.beginTransaction();
            if (session.get(User.class, name) != null) {
                tx.commit();
                session.close();
                String msg = "UserName already exist";
                request.setAttribute("msg", msg);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
                User user = new User();
                user.setUserName(name);
                user.setPassword(password);
                session.save(user);
                tx.commit();
                session.close();
                String msg = "Successfully signup.";
                request.setAttribute("msg", msg);
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

        }

    }


}

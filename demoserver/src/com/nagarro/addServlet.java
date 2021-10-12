package com.nagarro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class addServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
int i=Integer.parseInt(req.getParameter("num1"));
int j = Integer.parseInt(req.getParameter("num2"));
//System.out.println(1);s
int k = i + j;
// System.out.println(2);
// PrintWriter out=res.getWriter();
// out.println("result is" + k);
// req.setAttribute("k", k);
// RequestDispatcher dis = req.getRequestDispatcher("sq");
// dis.forward(req, res);
// sendDirect-1
// res.sendRedirect("sq?k=" + 9);
// 2
// HttpSession session = req.getSession();
// session.setAttribute("k", k);
// res.sendRedirect("sq");
// Cookie
Cookie cookie = new Cookie("k", k + "");
res.addCookie(cookie);
res.sendRedirect("sq");
}
}

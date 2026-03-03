package com.mycompany.controller;

import com.mycompany.dao.ContactDAO;
import com.mycompany.model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ContactServlet")
public class FormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Contact contact = new Contact();
        contact.setFullname(fullname);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setAddress(address);

        try {
            ContactDAO contactDAO = new ContactDAO();
            contactDAO.saveContact(contact);

            HttpSession session = request.getSession();
            session.setAttribute("userRole", "ADMIN");
            request.getRequestDispatcher("WEB-INF/views/result.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
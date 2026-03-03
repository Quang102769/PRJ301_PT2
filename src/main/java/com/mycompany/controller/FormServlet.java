package com.mycompany.controller;

import com.mycompany.dao.ContactDAO;
import com.mycompany.model.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ContactServlet")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

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

            request.setAttribute("saved", contact);
            request.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
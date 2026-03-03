package com.mycompany.dao;

import com.mycompany.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO {

    public void saveContact(Contact contact) throws SQLException {
        String query = "INSERT INTO Contacts (fullname, email, phone, address, created_at) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, contact.getFullname());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3, contact.getPhone());
            pstmt.setString(4, contact.getAddress());
            pstmt.executeUpdate();
        }
    }
}
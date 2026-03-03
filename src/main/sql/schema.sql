-- SQL Schema for Contacts Table
CREATE TABLE Contacts (
    id INT PRIMARY KEY IDENTITY(1,1),
    fullname VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    address VARCHAR(255),
    created_at DATETIME DEFAULT GETDATE()
);
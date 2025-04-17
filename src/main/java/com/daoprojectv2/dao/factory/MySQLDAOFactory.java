/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoprojectv2.dao.factory;

/**
 *
 * @author wesle
 */

import com.daoprojectv2.dao.interfaces.UserDAO;
import com.daoprojectv2.dao.mysql.MySQLUserDAO;
import com.daoprojectv2.dao.interfaces.OrderDAO;
import com.daoprojectv2.dao.interfaces.ProductDAO;
import com.daoprojectv2.dao.mysql.MySQLOrderDAO;
import com.daoprojectv2.dao.mysql.MySQLProductDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory { 
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/nome_do_banco";
    public static final String USER = "root";
    public static final String PASSWORD = "senha";

    @Override
    public Connection createConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(DBURL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado", e);
        }
    }
    
    @Override 
    public OrderDAO getOrderDAO (Connection conn) {
        return new MySQLOrderDAO(conn);
    }
    
    @Override 
    public ProductDAO getProductDAO (Connection conn) {
        return new MySQLProductDAO(conn);
    }
    
    @Override
    public UserDAO getUserDAO(Connection conn) {
        return new MySQLUserDAO(conn);
    }
}

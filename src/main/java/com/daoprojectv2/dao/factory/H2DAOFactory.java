/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoprojectv2.dao.factory;

import com.daoprojectv2.dao.h2.H2OrderDAO;
import com.daoprojectv2.dao.h2.H2ProductDAO;
import com.daoprojectv2.dao.h2.H2UserDAO;
import com.daoprojectv2.dao.interfaces.OrderDAO;
import com.daoprojectv2.dao.interfaces.ProductDAO;
import com.daoprojectv2.dao.interfaces.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wesle
 */
public class H2DAOFactory extends DAOFactory {
    public static final String DRIVER = "org.h2.Driver";
    public static final String DBURL = "jdbc:h2:~/testdb";
    
    @Override
    public UserDAO getUserDAO(Connection conn) {
        return new H2UserDAO(conn);
    }
    
    @Override 
    public OrderDAO getOrderDAO (Connection conn) {
        return new H2OrderDAO(conn);
    }
    
    @Override 
    public ProductDAO getProductDAO (Connection conn) {
        return new H2ProductDAO(conn);
    }
    
    @Override
    public Connection createConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(DBURL, "sa", "");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver H2 não encontrado", e);
        }
    }
}

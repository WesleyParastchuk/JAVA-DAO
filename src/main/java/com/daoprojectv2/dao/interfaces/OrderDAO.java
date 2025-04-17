/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoprojectv2.dao.interfaces;

/**
 *
 * @author wesle
 */
import com.daoprojectv2.model.Order;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    void create(Order order) throws SQLException;
    Order findById(int id) throws SQLException;
    List<Order> getAllOrders() throws SQLException;
    void update(Order order) throws SQLException;
    void deleteById(int id) throws SQLException;
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoprojectv2.dao.interfaces;

/**
 *
 * @author wesle
 */

import com.daoprojectv2.model.Product;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    void create(Product product) throws SQLException;
    Product findById(int id) throws SQLException;
    List<Product> getAllProducts() throws SQLException;
    void update(Product product) throws SQLException;
    void deleteById(int id) throws SQLException;
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoprojectv2.dao.interfaces;

/**
 *
 * @author wesle
 */

import com.daoprojectv2.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void create(User user) throws SQLException;
    User findById(int id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    void update(User user) throws SQLException;
    void deleteById(int id) throws SQLException;
}

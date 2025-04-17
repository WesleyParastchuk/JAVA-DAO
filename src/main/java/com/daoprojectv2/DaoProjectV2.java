/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.daoprojectv2;

import com.daoprojectv2.model.User;
import com.daoprojectv2.dao.interfaces.UserDAO;
import com.daoprojectv2.dao.factory.DAOFactory;
import com.daoprojectv2.dao.interfaces.OrderDAO;
import com.daoprojectv2.dao.interfaces.ProductDAO;
import com.daoprojectv2.model.Order;
import com.daoprojectv2.model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author wesle
 */
public class DaoProjectV2 {
    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.H2);
        
        try {
            Connection conn = daoFactory.createConnection();
            if (conn != null) {
                UserDAO userDAO = daoFactory.getUserDAO(conn);
                User newUser = new User(null, "Alice", "f", "123456789");
                userDAO.create(newUser);
                System.out.println("Usuário criado com ID: " + newUser.getId());

                ProductDAO productDAO = daoFactory.getProductDAO(conn);
                Product newProduct = new Product(null, "Produto A", "Descrição do Produto A", 100.0, 10);
                productDAO.create(newProduct);
                System.out.println("Produto criado com ID: " + newProduct.getId());

                OrderDAO orderDAO = daoFactory.getOrderDAO(conn);
                Order newOrder = new Order(null, newUser.getId(), newProduct.getId(), 2, newProduct.getPrice() * 2);
                orderDAO.create(newOrder);
                System.out.println("Pedido criado com ID: " + newOrder.getId());

                List<User> users = userDAO.getAllUsers();
                for (User user : users) {
                    System.out.println("ID: " + user.getId() + ", Nome: " + user.getNome() + ", Sexo: " + user.getSexo() + ", Telefone: " + user.getTelefone());
                }

                List<Product> products = productDAO.getAllProducts();
                for (Product product : products) {
                    System.out.println("ID: " + product.getId() + ", Nome: " + product.getName() + ", Descrição: " + product.getDescription() + ", Preço: " + product.getPrice());
                }

                List<Order> orders = orderDAO.getAllOrders();
                for (Order order : orders) {
                    System.out.println("ID: " + order.getId() + ", User ID: " + order.getUserId() + ", Product ID: " + order.getProductId() + ", Quantidade: " + order.getQuantity() + ", Valor Total: " + order.getTotalAmount());
                }
            } else {
                System.out.println("Falha ao criar a conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

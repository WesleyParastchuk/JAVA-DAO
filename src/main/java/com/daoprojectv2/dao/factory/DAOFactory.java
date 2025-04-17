package com.daoprojectv2.dao.factory;

import com.daoprojectv2.dao.interfaces.OrderDAO;
import com.daoprojectv2.dao.interfaces.ProductDAO;
import com.daoprojectv2.dao.interfaces.UserDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author wesle
 */
public abstract class DAOFactory {
    public static final int H2 = 1;
    public static final int MYSQL = 2;
    
    // DAOs que serão usados no projeto

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case H2:
                return new H2DAOFactory();
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
    
    public abstract UserDAO getUserDAO(Connection conn);
    
    public abstract OrderDAO getOrderDAO(Connection conn);
    
    public abstract ProductDAO getProductDAO(Connection conn);
    
    public abstract Connection createConnection() throws SQLException;
}

package Db;

import Data.Client;
import Data.Order;
import Data.Product;

import java.sql.*;

public class Service {

    private Service() {
    }

    public static void initDbClient(Connection connection) throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Client");
            st.execute("CREATE TABLE Client (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30) NOT NULL," +
                    " phone VARCHAR(30) NOT NULL)");
        }
    }

    public static void initDbOrders(Connection connection) throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Orders");
            st.execute("CREATE TABLE Orders (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, clientId INT NOT NULL," +
                    " productId INT NOT NULL, orderDate VARCHAR(30) NOT NULL)");
        }
    }

    public static void initDbProduct(Connection connection) throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Product");
            st.execute("CREATE TABLE Product (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, productName VARCHAR(30) NOT NULL," +
                    " price VARCHAR(30) NOT NULL, description VARCHAR(30) NOT NULL)");
        }
    }

    public static void addClient(Client client, Connection connection) throws SQLException {
        String query = "INSERT INTO Client(name, phone) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getPhone());
        preparedStatement.executeUpdate();
    }

    public static void addOrder(Order order, Connection connection) throws SQLException {
        String query = "INSERT INTO Orders(clientId,productId,orderDate) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, order.getClientId());
        preparedStatement.setInt(2, order.getProductId());
        preparedStatement.setDate(3, Date.valueOf(order.getOrderDate()));
        preparedStatement.executeUpdate();
    }

    public static void addProduct(Product product, Connection connection) throws SQLException {
        String query = "INSERT INTO Product(productName, price, description) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setLong(2, product.getPrice());
        preparedStatement.setString(3, product.getDescription());
        preparedStatement.executeUpdate();
    }
}

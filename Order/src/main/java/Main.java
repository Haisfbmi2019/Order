import Data.Order;
import Data.Product;
import Data.Client;
import Db.PropertiesDb;
import Db.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PropertiesDb properties = new PropertiesDb();
        try (Connection con = DriverManager.getConnection(properties.getUrl(), properties.getLogin(), properties.getPassword())) {
            Service.initDbClient(con);
            Service.initDbOrders(con);
            Service.initDbProduct(con);
            Client client1 = new Client("Vitalik", "09923413123");
            Product product1 = new Product("Chipseki", 35, "Lays");
            Order order1 = new Order(1, 1, "2020-04-05");

            Service.addClient(client1, con);
            Service.addProduct(product1, con);
            Service.addOrder(order1, con);
        }
    }
}

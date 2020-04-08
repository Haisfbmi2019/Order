package Data;

public class Order {
    private int clientId;
    private int productId;
    private String orderDate;

    public Order() {
    }

    public Order(int clientId, int productId, String orderDate) {
        this.clientId = clientId;
        this.productId = productId;
        this.orderDate = orderDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "clientId=" + clientId +
                ", productId=" + productId +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}

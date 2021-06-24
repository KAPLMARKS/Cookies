public class Product {
    int productID;
    String productName;
    // изначально в таблице указано как type - varchar, делать ли enum?

    public Product(int productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }
}

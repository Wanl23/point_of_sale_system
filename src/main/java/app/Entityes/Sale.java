package app.Entityes;

public class Sale {
    private Product product;
    private int newPrice;

    public Sale(Product product, int newPrice) {
        this.product = product;
        this.newPrice = newPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }
}

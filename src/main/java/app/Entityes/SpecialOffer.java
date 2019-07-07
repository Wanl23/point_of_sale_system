package app.Entityes;

public class SpecialOffer {
    private Product product;
    private int qtyNeedToBuy;
    private int getFree;

    public SpecialOffer(Product product, int qtyNeedToBuy, int getFree) {
        this.product = product;
        this.qtyNeedToBuy = qtyNeedToBuy;
        this.getFree = getFree;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQtyNeedToBuy() {
        return qtyNeedToBuy;
    }

    public void setQtyNeedToBuy(int qtyNeedToBuy) {
        this.qtyNeedToBuy = qtyNeedToBuy;
    }

    public int getGetFree() {
        return getFree;
    }

    public void setGetFree(int getFree) {
        this.getFree = getFree;
    }
}

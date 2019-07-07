package app.Entityes;

public class SpecialOffer {
    private Product product;
    private int qtyNeedToBuy;
    private int getFree;
    private int limit;

    public SpecialOffer(Product product, int qtyNeedToBuy, int getFree, int limit) {
        this.product = product;
        this.qtyNeedToBuy = qtyNeedToBuy;
        this.getFree = getFree;
        this.limit = limit;
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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

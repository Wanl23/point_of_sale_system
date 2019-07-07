package app.services;

import app.Entityes.Product;
import app.Entityes.Sale;
import app.Entityes.SpecialOffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalPriceService {

    private int totalPrice;
    private Map<Product, Integer> totalQty;
    private List<Sale> saleList;
    private List<SpecialOffer> specialOfferList;

    TotalPriceService(List<Sale> saleList, List<SpecialOffer> specialOfferList) {
        this.saleList = saleList;
        this.specialOfferList = specialOfferList;
    }

    public int plus(Product product, int qty) {
        if (totalQty == null) totalQty = new HashMap<>();
        saleList.stream().filter(s -> s.getProduct() == product)
                .forEach(s -> {
                    product.setPrice(s.getNewPrice());
                });
        specialOfferList.stream().filter(s -> s.getProduct() == product)
                .forEach(s -> {
                    if (s.getQtyNeedToBuy() == qty) {
                        totalQty.put(product, qty + 1);
                    }
                });
        totalPrice = totalPrice + product.getPrice() * qty;
        return totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getTotalQty(Product product) {
        return totalQty.get(product);
    }
}

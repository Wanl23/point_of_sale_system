package app.services;

import app.Entityes.Product;
import app.Entityes.Sale;
import app.Entityes.SpecialForSomePrice;
import app.Entityes.SpecialOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalPriceService {

    private int totalPrice;
    private Map<Product, Integer> totalQty;
    private List<Sale> saleList;
    private List<SpecialOffer> specialOfferList;
    private List<SpecialForSomePrice> specialForSomePriceList;
    private boolean useNormalPrice = true;

    TotalPriceService(List<Sale> saleList, List<SpecialOffer> specialOfferList, List<SpecialForSomePrice> specialForSomePriceList) {
        this.saleList = saleList;
        this.specialOfferList = specialOfferList;
        this.specialForSomePriceList = specialForSomePriceList;
    }

    public int plus(Product product, int qty) {
        if (totalQty == null) totalQty = new HashMap<>();
        if (saleList == null) saleList = new ArrayList<>();
        if (specialOfferList == null) specialOfferList = new ArrayList<>();
        if (specialForSomePriceList == null) specialForSomePriceList = new ArrayList<>();
        saleList.stream().filter(s -> s.getProduct() == product)
                .forEach(s -> {
                    product.setPrice(s.getNewPrice());
                });
        specialOfferList.stream().filter(s -> s.getProduct() == product)
                .forEach(s -> {
                    if (s.getQtyNeedToBuy() <= qty) {
                        int allowedProduct = qty / s.getQtyNeedToBuy();
                        if (allowedProduct <= s.getLimit())
                            totalQty.put(product, qty + allowedProduct);
                        else
                            totalQty.put(product, qty + s.getLimit());
                    }
                });
        specialForSomePriceList.stream().filter(s -> s.getProduct() == product)
                .forEach(s -> {
                    if (qty >= s.getQty()) {
                        totalPrice += (qty - (qty % s.getQty())) * s.getPrice() + (qty % s.getQty() * product.getPrice());
                        useNormalPrice = false;
                    }
                });
        if (useNormalPrice)
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

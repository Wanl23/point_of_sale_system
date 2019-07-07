package app.services;

import app.Entityes.Product;
import app.Entityes.Sale;

import java.util.List;

public class TotalPriceService {

    private int totalPrice;
    private List<Sale> saleList;

    TotalPriceService(List<Sale> saleList) {
        this.saleList = saleList;
    }

    public int plus(Product product) {
        saleList.stream().filter(s -> s.getProduct() == product)
                .forEach(s -> {
                    product.setPrice(s.getNewPrice());
                });
        totalPrice = totalPrice + product.getPrice();
        return totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}

package app.services;

import app.Entityes.Product;

public class TotalPriceService {

    private static int totalPrice;


    public int plus(Product product) {
        totalPrice = totalPrice + product.getPrice();
        return totalPrice;
    }

}

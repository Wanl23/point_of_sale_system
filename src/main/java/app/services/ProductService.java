package app.services;

import app.Entityes.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    public ProductService() {
    }

    public void add(Product product) {
        if (productList == null) productList = new ArrayList<>();
        productList.add(product);
    }

    public void remove(Product product) {
        if (!productList.contains(product)) {
            throw new IllegalArgumentException("There are not such product in products list");
        }
        productList.remove(product);
    }


}

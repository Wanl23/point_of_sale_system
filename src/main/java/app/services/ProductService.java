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
}

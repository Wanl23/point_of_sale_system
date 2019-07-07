package app.services;

import app.Entityes.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TotalPriceServiceTest {

    TotalPriceService totalPriceService;
    Product product;

    @Before
    public void setUp() throws Exception {
        totalPriceService = new TotalPriceService();
        product = new Product(1, "Bread","loaf", 5);
    }

    @Test
    public void WhenAddNewProductForCalculatingItReturnIncreasedFullSum() {
        Assert.assertEquals(totalPriceService.plus(product), product.getPrice());
    }

    @Test
    public void WhenAddNewProductForCalculatingItIncreasedTotalPrice() {
        totalPriceService.plus(product);
        Assert.assertEquals(totalPriceService.getTotalPrice(), product.getPrice());
    }
}

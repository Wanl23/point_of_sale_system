package app.services;

import app.Entityes.Product;
import app.Entityes.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TotalPriceServiceTest {

    TotalPriceService totalPriceService;
    Product product;
    List<Sale> saleList;
    Sale sale;

    @Before
    public void setUp() throws Exception {
        product = new Product(1, "Bread","loaf", 5);
        sale = new Sale(product, 4);
        saleList = new ArrayList<>();
        saleList.add(sale);
        totalPriceService = new TotalPriceService(saleList);
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

    @Test
    public void WhenAddProductForCalcAndThereAreSaleForThisProductItUseSumFromSale() {
        totalPriceService.plus(product);
        Assert.assertEquals(totalPriceService.getTotalPrice(), sale.getNewPrice());
    }
}

package app.services;

import app.Entityes.Product;
import app.Entityes.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SalesServiceTest {

    SaleService saleService;
    List<Sale> saleList;
    Sale sale;
    Product product;

    @Before
    public void setUp() throws Exception {
        saleList = new ArrayList<>();
        saleService = new SaleService(saleList);
        product = new Product(1, "Bread","loaf", 5);
        sale = new Sale(product, 3);
    }

    @Test
    public void WhenAddNewSaleItAppearInSaleList() {
        saleService.add(sale);
        Assert.assertEquals(saleList.get(0), sale);
    }

    @Test
    public void WhenRemoveSaleFromSaleListItDisappearFromSaleList() {
        saleList.add(sale);
        saleService.remove(sale);
        Assert.assertTrue(saleList.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenTryToRemoveNonexistentSaleItThrowAnException() {
        saleService.remove(sale);
    }
}

package app.services;

import app.Entityes.Product;
import app.Entityes.SpecialForSomePrice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpecialForSomePriceTest {

    SpecialForSomePriceService specialForSomePriceService;
    List<SpecialForSomePrice> specialForSomePriceList;
    SpecialForSomePrice specialForSomePrice;
    Product product;

    @Before
    public void setUp() throws Exception {
        specialForSomePriceList = new ArrayList<>();
        specialForSomePriceService = new SpecialForSomePriceService(specialForSomePriceList);
        product = new Product(1, "Bread","loaf", 5);
        specialForSomePrice = new SpecialForSomePrice(product, 3, 12);
    }

    @Test
    public void WhenAddSpecialOfferItAppearedInList() {
        specialForSomePriceService.add(specialForSomePrice);
        Assert.assertEquals(specialForSomePriceList.get(0), specialForSomePrice);
    }

    @Test
    public void WhenRemoveSpecialOfferItDisappearedFromList() {
        specialForSomePriceList.add(specialForSomePrice);
        specialForSomePriceService.remove(specialForSomePrice);
        Assert.assertTrue(specialForSomePriceList.isEmpty());
    }
}

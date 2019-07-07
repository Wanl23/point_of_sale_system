package app.services;

import app.Entityes.Product;
import app.Entityes.SpecialOffer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpecialOfferServiceTest {

    SpecialOfferService specialOfferService;
    SpecialOffer specialOffer;
    List<SpecialOffer> specialOfferList;

    @Before
    public void setUp() throws Exception {
        Product product = new Product(1, "bread", "loaf", 5);
        specialOffer = new SpecialOffer(product, 2, 1);
        specialOfferList = new ArrayList<>();
        specialOfferService = new SpecialOfferService(specialOfferList);
    }

    @Test
    public void WhenCreateNewOfferItAppearsInOffersList() {
        specialOfferService.add(specialOffer);
        Assert.assertEquals(specialOfferList.get(0), specialOffer);
    }
}

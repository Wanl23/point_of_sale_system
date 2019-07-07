package app.services;

import app.Entityes.Product;
import app.Entityes.Sale;
import app.Entityes.SpecialOffer;
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
    SpecialOffer specialOffer;
    List<SpecialOffer> specialOfferList;

    @Before
    public void setUp() throws Exception {
        product = new Product(1, "Bread","loaf", 5);
        sale = new Sale(product, 4);
        saleList = new ArrayList<>();
        saleList.add(sale);

        specialOffer = new SpecialOffer(product, 2, 1);
        specialOfferList = new ArrayList<>();
        specialOfferList.add(specialOffer);

        totalPriceService = new TotalPriceService(saleList, specialOfferList);
    }

    @Test
    public void WhenAddNewProductForCalculatingItReturnIncreasedFullSum() {
        Assert.assertEquals(totalPriceService.plus(product, 1), product.getPrice());
    }

    @Test
    public void WhenAddNewProductForCalculatingItIncreasedTotalPrice() {
        totalPriceService.plus(product, 1);
        Assert.assertEquals(totalPriceService.getTotalPrice(), product.getPrice());
    }

    @Test
    public void WhenAddProductForCalcAndThereAreSaleForThisProductItUseSumFromSale() {
        totalPriceService.plus(product, 1);
        Assert.assertEquals(totalPriceService.getTotalPrice(), sale.getNewPrice());
    }

    @Test
    public void WhenAddProductForCalcAndThereAreSpecialOfferItAddFreeProductIfOrderedQtyMatchOffer() {
        int qty = 2;
        totalPriceService.plus(product, qty);
        Assert.assertEquals(totalPriceService.getTotalQty(product), qty + specialOffer.getGetFree());
    }
}

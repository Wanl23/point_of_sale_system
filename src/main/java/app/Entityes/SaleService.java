package app.Entityes;

import java.util.ArrayList;
import java.util.List;

public class SaleService {

    private List<Sale> salesList;

    public SaleService(List<Sale> salesList) {
        this.salesList = salesList;
    }

    public SaleService() {
    }

    public void add(Sale sale) {
        if (salesList == null) {
            salesList = new ArrayList<>();
        }
        salesList.add(sale);
    }
}

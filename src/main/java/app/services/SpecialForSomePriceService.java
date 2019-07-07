package app.services;

import app.Entityes.SpecialForSomePrice;

import java.util.ArrayList;
import java.util.List;

public class SpecialForSomePriceService {

    private List<SpecialForSomePrice> specialForSomePriceList;

    public SpecialForSomePriceService(List<SpecialForSomePrice> specialForSomePriceList) {
        this.specialForSomePriceList = specialForSomePriceList;
    }

    public void add(SpecialForSomePrice specialForSomePrice) {
        if (specialForSomePriceList == null) specialForSomePriceList = new ArrayList<>();
        specialForSomePriceList.add(specialForSomePrice);
    }

    public void remove(SpecialForSomePrice specialForSomePrice) {
        if (!specialForSomePriceList.contains(specialForSomePrice)) throw new IllegalArgumentException("There are not such offer in SpecialFroSomePrice list");
        specialForSomePriceList.remove(specialForSomePrice);
    }
}

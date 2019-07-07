package app.services;

import app.Entityes.SpecialOffer;

import java.util.ArrayList;
import java.util.List;

public class SpecialOfferService {

    List<SpecialOffer> specialOfferList;

    public SpecialOfferService(List<SpecialOffer> specialOfferList) {
        this.specialOfferList = specialOfferList;
    }

    public SpecialOfferService() {
    }

    public void add(SpecialOffer specialOffer) {
        if (specialOfferList == null) specialOfferList = new ArrayList<>();
        specialOfferList.add(specialOffer);
    }

    public void remove(SpecialOffer specialOffer) {
        if (!specialOfferList.contains(specialOffer)) {
            throw new IllegalArgumentException("There are not such offer in offerList");
        }
        specialOfferList.remove(specialOffer);
    }
}

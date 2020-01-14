package org.training.restaurant.order.extra;

import java.util.ArrayList;

public class ExtraProducts {

    Extra ketchup = new Ketchup();
    Extra mustard = new Mustard();

    public String getKetchup() {
        return ketchup.extra();
    }

    public String getMustard() {
        return mustard.extra();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ketchup.extra());
        arrayList.add(mustard.extra());
        return arrayList;
    }
}

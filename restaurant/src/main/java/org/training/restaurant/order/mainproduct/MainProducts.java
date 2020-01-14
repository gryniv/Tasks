package org.training.restaurant.order.mainproduct;

import java.util.ArrayList;

public class MainProducts {


    Products hotDog = new HotDog();
    Products chips = new Chips();

    public String getHotDog() {
        return hotDog.product();
    }

    public String getChips() {
        return chips.product();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getChips());
        arrayList.add(getHotDog());
        return arrayList;
    }




}

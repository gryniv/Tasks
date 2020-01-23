package org.training.restaurant.entity.food.main;

import org.training.restaurant.entity.food.Products;

import java.util.ArrayList;

public class MainProducts {


    Products hotDog = new HotDog();
    Products chips = new Chips();

    public String getHotDog() {
        return hotDog.effect();
    }

    public String getChips() {
        return chips.effect();
    }

    public ArrayList<String> getAll() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(getChips());
        arrayList.add(getHotDog());
        return arrayList;
    }




}

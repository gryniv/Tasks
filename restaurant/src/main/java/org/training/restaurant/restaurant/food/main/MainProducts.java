package org.training.restaurant.restaurant.food.main;

import org.training.restaurant.restaurant.food.main.products.Chips;
import org.training.restaurant.restaurant.food.main.products.HotDog;

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

    public ArrayList<String> getAll() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(getChips());
        arrayList.add(getHotDog());
        return arrayList;
    }




}

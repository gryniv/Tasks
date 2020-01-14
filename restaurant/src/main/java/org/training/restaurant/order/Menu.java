package org.training.restaurant.order;

import org.training.restaurant.order.extra.ExtraProducts;
import org.training.restaurant.order.mainproduct.MainProducts;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Menu {

    ExtraProducts extraProducts = new ExtraProducts();
    MainProducts mainProducts = new MainProducts();

    public ArrayList getMenu() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(mainProducts.getAll());
        arrayList.addAll(extraProducts.getAll());

        return arrayList;
    }

    public ArrayDeque createOrder(){
        ArrayDeque queue = new ArrayDeque();
        queue.add(mainProducts.getChips());
        queue.add(mainProducts.getHotDog());

        return queue;
    }
}

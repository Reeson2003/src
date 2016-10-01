package ru.reeson2003.items;

import ru.reeson2003.map.Interactable;

/**
 * Created by Тоня on 01.10.2016.
 */
public abstract class Item implements Interactable{
    protected String name = "";
    protected String info = "";
    protected int price = 0;
    protected Item(String name, String info, int price) {
        if(name != null)
            this.name = name;
        if (info != null)
            this.name = name;
        if (price >=0)
            this.price = price;
    }
}
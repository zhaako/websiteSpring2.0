package com.youtube.blog.db;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Items> items = new ArrayList<>();
    static {
        items.add(new Items(1L,"Iphone 11 Pro",500000));
        items.add(new Items(2L,"Xiaomi Redmi",300000));
        items.add(new Items(3L,"Samsung Galaxy A72",250000));
        items.add(new Items(4L,"Nokia 3120",200000));
    }

    private static ArrayList<Cars> allCars = new ArrayList<>();
    static{
        allCars.add(new Cars(1L, "Mercedes",2.7, 220));
        allCars.add(new Cars(2L, "Toyota",2.2, 210));
        allCars.add(new Cars(3L,"Kia",1.6,190));
        allCars.add(new Cars(4L,"Lexus",3.3,240));
        allCars.add(new Cars(5L,"Range Rover",4.8,300));
        allCars.add(new Cars());
    }
    private static Long id = 5L;

    public static ArrayList<Items> getItems(){
        return items;
    }
    public static ArrayList<Cars> getAllCars(){
        return allCars;
    }

    public static void addItem(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Items getItem(Long id){
        for (Items it:items){
            if(it.getId() == id) return it;
        }
        return null;
    }

}

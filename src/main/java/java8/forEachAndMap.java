package java8;

import java.util.*;
import java.util.stream.Collectors;

public class forEachAndMap {
    public static void main(String[] args) {
        System.out.println("Clalssic Type");
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        System.out.println("############################################################################################");
        //System.out.println("Type list values 1");
        //items.forEach(System.out::println);
        System.out.println("With Java 8 forEach and Map and Lambda");
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count :" + v));

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("With for Each find spesific key and value");
        items.forEach((k,v)->{if(k.equals("E")){
            System.out.println("Hello Java 8");
            System.out.println("Found Item : " +k + " Count :" +v);}
        });


    }

}

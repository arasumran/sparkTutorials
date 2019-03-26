package java8;

import java8.DummyClasses.Developer;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args)
    {
        // Classic Comparator
        Comparator<Developer> byName = new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Developer> byNamewithLambda = (Developer d1, Developer d2)->d1.getName().compareTo(d2.getName());



    }
}

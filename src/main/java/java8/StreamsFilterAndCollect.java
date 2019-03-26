package java8;

import java8.DummyClasses.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterAndCollect {
    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "winter", "summer");
        List<String> cLassicResult = getFilterOutput(lines, "winter");
        System.out.println("Classic Type display");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (String temp : cLassicResult) {
            System.out.println(temp);    //output : spring, summer

        }
        System.out.println("--------------------------------------------------------------------------------------------");
        List<Person> persons = Arrays.asList(
                new Person("alice", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result = getStudentByName(persons, "jack");
        System.out.println(result.getName() +" - "+result.getAge());
        System.out.println("\n############################################################################################");
        System.out.println("New Type Display");
        System.out.println("-------------------------------------------------------------------------------------------");
        List<String> newVerResult = lines.stream()                // convert list to stream
                .filter(line -> !"winter".equals(line))     // we dont like winter
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        newVerResult.forEach(System.out::println);//output : spring, summer
        System.out.println("-------------------------------------------------------------------------------------------");

        Person p1 = persons.stream().filter(p ->"jack".equals(p.getName())).findAny().orElse(null);
        System.out.println(p1.getName() +" - " + p1.getAge());


        List<Person> personss = Arrays.asList(
                new Person("alice", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        String name = personss.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = personss.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);


    }






    private static List<String> getFilterOutput(List<String> lines, String filter) {

        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"winter".equals(line)) { // we dont like mkyong
                result.add(line);
            }
        }
        return result;


    }
    private static Person getStudentByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }
}

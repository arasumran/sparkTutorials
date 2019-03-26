package com.example.sparkTutorial.RDD;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.event.Level;

import org.apache.log4j.Logger;
import static org.slf4j.event.Level.*;
import static org.slf4j.event.Level.ERROR;

public class SparkRDDs {
    public static void main(String[] args) {
        System.out.println("\t\t\tHello Mello\t\n" +
                "Today we are talking about Spark RDD examples\n" +
                "So firstly we have to understand whats s RDD and\n" +
                "how can we use it for our apps..................\n" +
                "\t\t\tLETS START\n");

        /****
         * THIS LOGGER LEVEL TO ESCAPE FROM NOISY LOGGING
         * */
        Logger.getLogger("org").setLevel(org.apache.log4j.Level.ERROR);
        Logger.getLogger("com").setLevel(org.apache.log4j.Level.ERROR);

        /*How to create RDD*/
        /*
        List<Integer> listIntegers = Arrays.asList(1,2,3,4,5);
        SparkConf sparkConf = new SparkConf().setMaster("local[4]").setAppName("KeywordDetect");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<Integer> integerRDD = sc.parallelize(listIntegers);

      */
        //local mean s use available cores for this exam we said use two core
        SparkConf conf = new SparkConf().setAppName("airports").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> airports = sc.textFile("src/main/resources/in/airports.text");
        //this is for airports in United States
        JavaRDD<String> airportsInUSA = airports.filter(line -> line.split(",")[3].equals("\"United States\""));

        /* OR another type of map -filter
        Airports Latitude for bigger than 40 example
        JavaRDD<String> airportsInUSA = airports.filter(line -> Float.valueof(line.split(",")[6])> 40);
        */
        JavaRDD<String> airportsNameAndCityNames = airportsInUSA.map(line -> {
                    String[] splits = line.split(",");
                    return StringUtils.join(new String[]{splits[1], splits[2], splits[3]}, ",");
                }
        );
        airportsNameAndCityNames.collect().forEach(l -> System.out.println(l));
        //OR for save as file
        /*airportsNameAndCityNames.saveAsTextFile("out/airports_in_united_states");*/



        ////////////////////////FlatMap vs Map /////////////////////////////////////////////////////

        /***
        * map : 1 to 1 relationship
        * flatmap :1 to many relationship, must work by iterator
         *
         *PASSING FUNC. TO SPARK
         *
         * ...  some of actions operations requires passing func. which will be usd by Spark to compute data
         *
         * org.apache.spark.api.java.function
         * ......most popular func.............
         * public interface Function <T1, R > extends Serializable{
         *     --- takes one input response one output
         *     this interface is widely used for operations like map and filter the function to interface
         * }
         *
         * public interface Function2<T1,T2,R> extends Serializable{
         *
         * R call (T1 var1, T2 var2)
         *
         * this is used for operations uch as aggregate or reduce aggregate and reducce are both Spark actions
         * }
         *
         * public interface flatMapFunction <T,R> extends Serializable{
         *
         *     Iterator<R> call (T t ) throws Exception;
         *
         *     the flat map function take one input and returns a 0 or more outputs
         *     this is used for operated flat map
         *
         * }
         *
        ***/

    }
}

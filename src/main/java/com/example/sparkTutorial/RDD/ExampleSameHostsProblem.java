package com.example.sparkTutorial.RDD;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ExampleSameHostsProblem {

    public static void main(String[] args) throws Exception {

        /* "in/nasa_19950701.tsv" file contains 10000 log lines from one of NASA's apache server for July 1st, 1995.
           "in/nasa_19950801.tsv" file contains 10000 log lines for August 1st, 1995
           Create a Spark program to generate a new RDD which contains the hosts which are accessed on BOTH days.
           Save the resulting RDD to "out/nasa_logs_same_hosts.csv" file.

           Example output:
           vagrant.vf.mmc.com
           www-a1.proxy.aol.com
           .....

           Keep in mind, that the original log files contains the following header lines.
           host	logname	time	method	url	response	bytes

           Make sure the head lines are removed in the resulting RDD.
         */
        SparkConf conf = new SparkConf().setAppName("unionLogs").setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> julyFisrtLogs = sc.textFile("src/main/resources/in/nasa_19950701.tsv");

        JavaRDD<String> augstFirst = sc.textFile("src/main/resources/in/nasa_19950801.tsv");

        JavaRDD<String> julyFirstHosts = julyFisrtLogs.map(line -> line.split("\t")[0]);

        JavaRDD<String> augustFirstHosts = augstFirst.map(line -> line.split("\t")[0]);

        JavaRDD<String> intersection = julyFirstHosts.intersection(augustFirstHosts);

        JavaRDD<String> cleanedHostIntersection = intersection.filter(host -> !host.equals("host"));
        cleanedHostIntersection.saveAsTextFile("src/main/resources/out/sample_same_hosts_logs.csv");

    }


}
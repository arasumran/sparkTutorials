package com.example.sparkTutorial.BasicSamples;


import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.*;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

public class JavaWordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {

        Logger.getLogger("org").setLevel(Level.ERROR);
        Logger.getLogger("com").setLevel(Level.ERROR);

        SparkConf sparkConf = new SparkConf().setAppName("KeywordDetect").setMaster("local[4]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> lines = sc.textFile("some_file-path");

      JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        Map<String,Long> wordCounts = words.countByValue();

        for (Map.Entry<String, Long> entry :wordCounts.entrySet())
        {
            System.out.println(entry.getKey() +":" + entry.getValue());
        }


    }
}

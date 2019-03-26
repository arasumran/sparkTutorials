package com.example.sparkTutorial.BasicSamples;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.sql.execution.datasources.csv.CSVFileFormat;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

public class sparkFTPSender {
    private static final Pattern SPACE = Pattern.compile(" ");
    private static String ftpHost = null;
    private static String ftpUsername = null;
    private static String ftpPassword = null;
    private static String fileName = null;
    private static SparkSession spark;
    private static  String csvPath = "src/main/resources/in/ftptest.csv";



    public static void main(String[] args) {

        Logger.getLogger("org").setLevel(Level.ERROR);
        Logger.getLogger("com").setLevel(Level.ERROR);
        fileName = String.format("%s-%s", RandomStringUtils.random(5, "0123456789abcdef"), new Timestamp(System.currentTimeMillis()).getTime());
        String destination = "/data/";
        ftpHost = String.format("%s", "FTP_HOST");
        ftpUsername = String.format("%s", "FTP_USER");
        ftpPassword = String.format("%s", "FTP_PASS");


        System.out.println(String.format("filename: %s", fileName));
        System.out.println(String.format("destination: %s", destination));

        SparkConf sparkConf = new SparkConf().setAppName("LoadCsv").setMaster("local[*]");
        SparkSession sparkSession = spark.builder().config(sparkConf).appName("Spark Session Example").getOrCreate();
        Dataset<Row> ss = sparkSession.read()
                .format("com.databricks.spark.csv")
                .option("mode", "DROPMALFORMED")
                .option("header", "true")
                .option("delimiter", ",")
                .option("inferSchema", "true")
                .option("timestampFormat", "dd/MM/yyyy")
                .load(csvPath);
        ss.repartition(1)
                .write().format("com.springml.spark.sftp")
                .mode(SaveMode.Append).option("header", "true")
                .option("delimiter", ",")
                .option("path",destination)
                .option("host", ftpHost)
                .option("username", ftpUsername)
                .option("password", ftpPassword)
                .option("fileType", "csv")
                .save(String.format("%s.csv", fileName));


    }
}

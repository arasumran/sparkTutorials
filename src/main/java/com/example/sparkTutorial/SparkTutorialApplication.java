package com.example.sparkTutorial;

import com.example.sparkTutorial.Utils.Record;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SparkTutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SparkTutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		String csvFilePath = "src/main/resources/in/1500000_record.csv";
		SparkSession spark = SparkSession
				.builder()
				.appName("Java Spark SQL Example")
				.master("local[*]")
				.getOrCreate();

		StructType schema = new StructType()
				.add("Region", DataTypes.StringType)
				.add("Country", DataTypes.StringType)
				.add("ItemType", DataTypes.StringType)
				.add("SalesChannel", DataTypes.StringType)
				.add("OrderPriority", DataTypes.StringType)
				.add("OrderDate", DataTypes.DateType)
				.add("OrderId", DataTypes.IntegerType)
				.add("ShipDate", DataTypes.DateType)
				.add("UnitsSold", DataTypes.DoubleType)
				.add("UnitPrice", DataTypes.DoubleType)
				.add("UnitCost", DataTypes.DoubleType)
				.add("TotalRevenue", DataTypes.DoubleType)
				.add("TotalCost", DataTypes.DoubleType)
				.add("TotalProfit", DataTypes.DoubleType);
		Dataset<Record> df = spark.read()
				.format("com.databricks.spark.csv")
				.option("mode", "DROPMALFORMED")
				.option("header", "false")
				.option("inferSchema", "true")
				.option("timestampFormat", "dd/MM/yyyy")
				.schema(schema)
				.load(csvFilePath).as(Encoders.bean(Record.class));
		df.show(100);


	}
}


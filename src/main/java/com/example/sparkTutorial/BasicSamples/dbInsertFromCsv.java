package com.example.sparkTutorial.BasicSamples;

import com.example.sparkTutorial.Utils.Record;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import java.util.HashMap;

public class dbInsertFromCsv {
    /****
     This example read from million data from csv and insert  to RMDB

     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String csvFilePath = "src/main/resources/in/1500000_record.csv";
        //SparkSession sparkSession = SparkSession.builder().appName("TestAppName").master("local[*]").getOrCreate();
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL Example")
                .master("local[*]")
                .getOrCreate();

        StructType schema = new StructType()
                .add("Region", DataTypes.StringType,true)
                .add("Country", DataTypes.StringType,true)
                .add("ItemType", DataTypes.StringType,true)
                .add("SalesChannel", DataTypes.StringType,true)
                .add("OrderPriority", DataTypes.StringType,true)
                .add("OrderDate", DataTypes.DateType,true)
                .add("OrderId", DataTypes.IntegerType,true)
                .add("UnitsSold", DataTypes.DoubleType,true)
                .add("UnitPrice", DataTypes.DoubleType,true)
                .add("UnitCost", DataTypes.DoubleType,true)
                .add("TotalRevenue", DataTypes.DoubleType,true)
                .add("TotalCost", DataTypes.DoubleType,true)
                .add("TotalProfit", DataTypes.DoubleType,true)
                .add("ShipDate", DataTypes.DateType,true);
        HashMap<String,String > modelmap = new HashMap<>();
        Dataset<Row> df = spark.read()
                .option("mode", "DROPMALFORMED")
                .option("header", "true")
                .option("delimiter", ",")
                .option("inferSchema", "true")
                .option("timestampFormat", "dd/MM/yyyy")
                .schema(schema)
                .load(csvFilePath);
        df.show(100);

        System.out.println("hele");


     /*   SparkConf conf = new SparkConf()
                .setAppName("SF")
                .setMaster("local[*]")
                .set("com.couchbase.bucket.default", "");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(javaSparkContext);

        Dataset<Record> dataFrame = sqlContext.read()
                .format("com.databricks.spark.csv")
                .option("inferSchema", "true")
                .option("header", "true")
                .load(csvFilePath).as(Encoders.bean(Record.class));
        dataFrame.filter(l->l.getRegion().equalsIgnoreCase("Europe")).select("Region").show(100);
        System.out.println(dataFrame.count());
*/


//##################################################################################################################################################

   /*     SparkConf sparkConf = new SparkConf().setAppName("LoadCsv").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        //JavaRDD<String> lines = sc.textFile(csvFilePath);
        SparkSession sparkSession = SparkSession.builder().config(sparkConf).appName("Spark Session Example").getOrCreate();
        Dataset<Record> ss = sparkSession.read().option("header","true").option("inferSchema","true").csv(csvFilePath).as(Encoders.bean(Record.class));
        List<String> listTwo = ss.map(row -> row.getCountry(), Encoders.STRING()).collectAsList();


        System.out.println(listTwo);

        */
        //##########################################################################################################################################

        /*JavaPairRDD<String, Iterable<String>> newLines = lines.keyBy(new Function<String,String>(){

            @Override
            public String call(String arg0) throws Exception {
                return arg0.split(",")[0];
            }
        }).mapValues(new Function<String, Iterable<String>>(){
            @Override
            public Iterable<String> call(String arg0) throws Exception {
                return Arrays.asList(arg0.split(","));
            }
        });
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");

        newLines.foreach(data -> {
            System.out.println("model="+data._1() + " label=" + data._2());
        });

        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
*/

      /*  Dataset<Row> jdbcDF = spark.read()
                .format("jdbc")
                .option("url", "jdbc:postgresql:dbserver")
                .option("dbtable", "schema.tablename")
                .option("user", "username")
                .option("password", "password")
                .load();
*/

   /*   SQLContext sq = new SQLContext(sc);

      Dataset<Row> jdbcDF =sq.read().format("jdbc").
            option("url", "jdbc:postgresql:dbserver")
            .option("dbtable", "schema.tablename")
            .option("user", "umran")
            .option("password", "q1w2e3r4")
            .load();
      jdbcDF.write();


*/
    }
}

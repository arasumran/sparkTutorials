package com.example.sparkTutorial.RDD;

public final class Tests {
       /* private static final Pattern SPACE = Pattern.compile(" ");
        public static List<String> keywords=new ArrayList<String>();
        public static void v(String[] args) throws InterruptedException {
            SpringApplication.run(SparkTutorialApplication.class, args);

            if (args.length < 2) {
                System.err.println("Usage: KeywordDetect <hostname> <port> <words>");
                System.exit(1);
            }

            SparkConf sparkConf = new SparkConf().setMaster("local[4]").setAppName("KeywordDetect");

            JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
            JavaDStream<String> filelines = ssc.textFileStream("src/main/resources/shakespeare.txt.txt");

            JavaReceiverInputDStream<String> lines = ssc.socketTextStream(
                    args[0], Integer.parseInt(args[1]), StorageLevels.MEMORY_AND_DISK_SER);

            keywords.add("initial"); //Initialize keyword list

            JavaDStream<String> updatedKeyWords = filelines.flatMap(new FlatMapFunction<String,String>() {
                @Override
                public Iterator<String> call(String x) {
                    final Pattern SPACE = Pattern.compile(" ");
                    String[] vec=SPACE.split(x);
                    List<String> ls=Arrays.asList(vec);

                    return (Iterator<String>) ls;
                }
            });

            updatedKeyWords.foreachRDD(new VoidFunction<JavaRDD<String>>(){
                public void call(JavaRDD<String> rdd) {

                    rdd.foreach(new VoidFunction<String>() {
                        @Override
                        public void call(String x) {
                            //x=x+1;
                            if (x != null)
                                keywords.add(x); //add newly read tokens to keyword list

                        }
                    });

                }

            });


            JavaDStream<Boolean> wordPresent = lines.map(new Function<String, Boolean>() {
                @Override
                public Boolean call(String x) {
                    return keywords.contains(x); //compare token received from socket against keywords list
                }
            });

            JavaDStream<String> inputWords = lines.map(new Function<String, String>() {
                @Override
                public String call(String x) {
                    return x;
                }
            });

            wordPresent.print();

            ssc.start();
            ssc.awaitTermination();*/
}
    //}


//     SparkConf conf = new SparkConf().setMaster("local").setAppName("Word Count");
//
//        // Create a Java version of the Spark Context
//        JavaSparkContext sc = new JavaSparkContext(conf);
//
//        // Load the text into a Spark RDD, which is a distributed representation of each line of text
//        JavaRDD<String> textFile = sc.textFile("src/main/resources/shakespeare.txt.txt");
//        JavaPairRDD<String, Integer> counts = textFile
//                .flatMap(s -> Arrays.asList(s.split("[ ,]")).iterator())
//                .mapToPair(word -> new Tuple2<>(word, 1))
//                .reduceByKey((a, b) -> a + b);
//        counts.foreach(p -> System.out.println(p));
//        System.out.println("Total words: " + counts.count()); ====> 15 sn


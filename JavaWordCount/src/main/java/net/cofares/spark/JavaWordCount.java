/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.cofares.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

import java.util.Arrays;


/**
 * Sample Spark application that counts the words in a text file
 */
public class JavaWordCount
{

    

    public static void wordCountJava8( String filename )
    {
        // Define a configuration to use to interact with Spark
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Work Count App");

        // Create a Java version of the Spark Context from the configuration
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines = sc.textFile(filename);
        JavaRDD<String> words =
                       lines.flatMap(line -> Arrays.asList(line.split(" ")));
        JavaPairRDD<String, Integer> counts =
        words.mapToPair(w -> new Tuple2<String, Integer>(w, 1))
         .reduceByKey((x, y) -> x + y);

        counts.saveAsTextFile("cout.res");
    }

    public static void main( String[] args )
    {
        if( args.length == 0 )
        {
            System.out.println( "Usage: WordCount <file>" );
            System.exit( 0 );
        }

        wordCountJava8( args[ 0 ] );
    }
}

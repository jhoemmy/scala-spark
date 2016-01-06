package org.scala.spark.scalaspark
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
object sparktest {
  def main(args: Array[String]) = {

    //Start the Spark context
    val conf = new SparkConf()
      .setAppName("sparktest")
      .setMaster("local")
    val sc = new SparkContext(conf)  
    
    //Read some example file to a test RDD
    val fileholder = sc.textFile("c://study/spark/spark1.6/README.md")
    val numHadoop = fileholder.filter(line => line.contains("Hadoop")).count()
    val numSpark = fileholder.filter(line => line.contains("Spark")).count()
    println(s"Number of Hadoop in the file : $numHadoop and Number of Sparks : $numSpark")
  }
}
#Count Word of a file in spark-shell

run `spark-shell`

##Copy/pase line by line

```scala
val text = sc.textFile("afile")
val counts = text.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
counts.collect
```

##Writing a acala script 


```bash
pascalfares@DEV:~/mesgit/sparkWorkshop/WordCount$ cat wordCount.scala 
val text = sc.textFile("afile")
val counts = text.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
counts.collect
```

###Then you could lanch the script

1. like this:

`spark-shell -i wordCount.scala`

2. or in spark-shell

`:load wordCount.scala`

##More advanced

###Removing useless chars
```scala
//Going to remove : / and " by replacing it by space
val regex = "[:/\"]".r

val ntext = text.map(line => regex.replaceAllIn(line, " "))
```

###The count words
```scala
val counts = ntext.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
counts.foreach(println(_))
```










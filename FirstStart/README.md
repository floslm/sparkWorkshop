# First start 

run spark-shell
```bash
spark-shell
```
## then copy/paste each of these lines (one by one)

```spark
val textFile = sc.textFile("forTesting.md") //Initialise the RDD from external file
textFile.count() // Number of items in this RDD
textFile.first() // First item in this RDD
val linesWithSpark = textFile.filter(line => line.contains("Spark"))
linesWithSpark.count()
textFile.filter(line => line.contains("Spark")).count() // How many lines contain "Spark"?
```

###Get the logest line
```
val linesSize = textFile.map(line => line.split(" ").size)
linesSize.collect() // Show the result every thing is an RDD
linesSize.reduce((a, b) => if (a > b) a else b)
```
### In one step 
```scala
textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)
```
### How this work? ..... 

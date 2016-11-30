val text = sc.textFile("afile")
val counts = text.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
counts.collect

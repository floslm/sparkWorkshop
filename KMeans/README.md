##Imports

> 	import org.apache.spark.mllib.clustering.KMeans
> 	import org.apache.spark.mllib.linalg.Vectors
> 	import org.apache.spark.mllib.util.KMeansDataGenerator


##Generate data

KMeansDataGenerator.generateKMeansRDD

Generate test data for KMeans. This class first chooses k cluster centers from a d-dimensional Gaussian distribution scaled by factor r and then creates a Gaussian cluster with scale 1 around each center.

###Parameters:

* sc - SparkContext to use for creating the RDD
* numPoints - Number of points that will be contained in the RDD
* k - Number of clusters
* d - Number of dimensions
* r - Scaling factor for the distribution of the initial centers
* numPartitions - Number of partitions of the generated RDD; default 2

###Type theses

> val donneesGenerees = KMeansDataGenerator.generateKMeansRDD(sc, 1000, 5, 3, 5, 1)
> val donnees = donneesGenerees.map(s => Vectors.dense(s)).cache()
> donnees.take(2)

###Save daTA

> val donneesTxt = donnees.map(l => l.toString.filter(c => c != '[' & c != ']'))
> donneesTxt.saveAsTextFile("data/datas")

### Apply k-means


> val nbClusters = 5
> val nbIterations = 200
> val clusters = KMeans.train(donnees, nbClusters, nbIterations)

// Evaluer la classification par la somme des inerties intra-classe
> val siic1 = clusters.computeCost(donnees)

// Trouver l'indice de groupe pour chaque donnée
> val indices = clusters.predict(donnees)

// Enregistrer les indices dans un fichier texte
> indices.saveAsTextFile("data/indices")

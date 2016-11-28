# Calculation of Pi Using the Monte Carlo Method

If a circle of radius R is inscribed inside a square with side length 2R, then the area of the circle will be pi*R^2 and the area of the square will be (2R)^2. So the ratio of the area of the circle to the area of the square will be pi/4.

This means that, if you pick N points at random inside the square, approximately N*pi/4 of those points should fall inside the circle.

This program picks points at random inside the square. It then checks to see if the point is inside the circle (it knows it's inside the circle if x^2 + y^2 < R^2, where x and y are the coordinates of the point and R is the radius of the circle). The program keeps track of how many points it's picked so far (N) and how many of those points fell inside the circle (M).

Pi is then approximated as follows:

>      4*M
> pi = ----
>       N


##Follow these steps

NUM_SAMPLES a big number (that you memory can handle)

> val NUM_SAMPLES=1000000

> val count = sc.parallelize(1 to NUM_SAMPLES).map{i =>
>  val x = Math.random()
>  val y = Math.random()
>  if (x*x + y*y < 1) 1 else 0
>}.reduce(_ + _)


>println("Pi is roughly " + 4.0 * count / NUM_SAMPLES)

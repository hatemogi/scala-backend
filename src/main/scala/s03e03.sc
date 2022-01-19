/*
  Ordered[A] : compare(that: A): Int
   Returns x where:
     x < 0 when this < that
     x == 0 when this == that
     x > 0 when this > that
 */

implicit def list2ordered[A](x: List[A])
  (implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] =
  new Ordered[List[A]] {
    //replace with a more useful implementation
    def compare(that: List[A]): Int = 1
  }

List(1, 2, 3) <= List(4, 5)

"Hello World".take(5)

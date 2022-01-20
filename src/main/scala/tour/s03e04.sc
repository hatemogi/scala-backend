def listOfDuplicates[A](x: A, length: Int): List[A] = {
  if (length < 1)
    Nil
  else
    x :: listOfDuplicates(x, length - 1)
}

listOfDuplicates[Int](3, 4)
listOfDuplicates("La", 8)
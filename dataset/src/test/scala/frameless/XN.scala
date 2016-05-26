package frameless

import org.scalacheck.Arbitrary

case class X1[A](a: A)

object X1 {
  implicit def arbitrary[A: Arbitrary]: Arbitrary[X1[A]] = {
    Arbitrary(implicitly[Arbitrary[A]].arbitrary.map(X1(_)))
  }

  implicit def ordering[A: Ordering]: Ordering[X1[A]] = Ordering[A].on(_.a)
}

case class X2[A, B](a: A, b: B)

object X2 {
  implicit def arbitrary[A: Arbitrary, B: Arbitrary]: Arbitrary[X2[A, B]] = {
    Arbitrary(Arbitrary.arbTuple2[A, B].arbitrary.map((X2.apply[A, B] _).tupled))
  }

  implicit def ordering[A: Ordering, B: Ordering]: Ordering[X2[A, B]] = Ordering.Tuple2[A, B].on(x => (x.a, x.b))
}

case class X3[A, B, C](a: A, b: B, c: C)

object X3 {
  implicit def arbitrary[A: Arbitrary, B: Arbitrary, C: Arbitrary]: Arbitrary[X3[A, B, C]] = {
    Arbitrary(Arbitrary.arbTuple3[A, B, C].arbitrary.map((X3.apply[A, B, C] _).tupled))
  }

  implicit def ordering[A: Ordering, B: Ordering, C: Ordering]: Ordering[X3[A, B, C]] =
    Ordering.Tuple3[A, B, C].on(x => (x.a, x.b, x.c))
}

case class X4[A, B, C, D](a: A, b: B, c: C, d: D)

object X4 {
  implicit def arbitrary[A: Arbitrary, B: Arbitrary, C: Arbitrary, D: Arbitrary]: Arbitrary[X4[A, B, C, D]] = {
    Arbitrary(Arbitrary.arbTuple4[A, B, C, D].arbitrary.map((X4.apply[A, B, C, D] _).tupled))
  }

  implicit def ordering[A: Ordering, B: Ordering, C: Ordering, D: Ordering]: Ordering[X4[A, B, C, D]] =
    Ordering.Tuple4[A, B, C, D].on(x => (x.a, x.b, x.c, x.d))
}

package com.ringohub.paillier

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PaillierKeyTest extends Specification {
  "PaillerKey" should {
    "A" in {
      val p = PaillierKey()
      println(p.p)
      println(p.q)
      println(p.n)
      println(p.λ)
      1 must_== 1
      p.n/p.q must_== p.p
      p.n/p.p must_== p.q

    }
  }
}

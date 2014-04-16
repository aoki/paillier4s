package com.ringohub.paillier

import java.security.SecureRandom
import scala.util.Random

object PaillierKey {
  def apply() = new PaillierKey()
}

case class PaillierKey private(bitLength: Int = 1024, certainty: Int = 1000 , rnd: Random = new SecureRandom()) extends Key {

  // TODO: Generate Key 安全素数を使う
  // TODO: Lucas–Lehmer primality test

  // 秘密鍵
  val p: BigInt = BigInt(bitLength, certainty, rnd)
  val q: BigInt = BigInt(bitLength, certainty, rnd)
  val λ: BigInt = (p - 1) * (q - 1)
  val d: BigInt = n modInverse λ

  // 公開鍵
  val n: BigInt = p * q

  /**
   * 公開鍵を返すメソッド
   * TODO: PublickKeyのcase classを作ってもいいかも
   */
  def public = n
  def secret = (p, q)

}

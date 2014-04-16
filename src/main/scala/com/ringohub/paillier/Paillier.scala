import com.ringohub.paillier.PaillierKey

import java.security.SecureRandom
import scala.util.Random

object Paillier {
  def apply(key: PaillierKey) = new Paillier(key)

  // TODO: def apply() = new Paillier
  // TODO: def apply(n: BigInt)
  // TODO: def apply(p: BigInt, q: BigInt)
}

//trait Encryption {
//  def encrypt(plainText: BigInt)(bitLength: Int)(certainty: Int = 1000): BigInt = {
//    val r = BigInt(bitLength, certainty, new SecureRandom())
//  }
//  def E(plainText: BigInt): BigInt = encrypt(plainText: BigInt)
//  def ↦(plainText: BigInt): BigInt = encrypt(plainText: BigInt)
//
//  // TODO: def encrypt(plainText: String): BigInt
//  // TODO: def encrypt(plainText: Int): BigInt
//}

//trait Decryption {
//  def decrypt(cipherText: BigInt): BigInt = {
//
//  }
//  def D(cipherText: BigInt): BigInt = decrypt(cipherText)
//
//  // TODO: def decrypt(cipherText: BigInt): String
//  // TODO: def decrypt(cipherText: BigInt): Int
//}

case class Paillier(key: PaillierKey) {
  val certainty: Int = 1000

  def encrypt(m: BigInt): BigInt = {
    // g^m * r^n mod n^2
    ((key.n + 1).modPow(m, key.n*key.n) * BigInt(key.n.bitLength, certainty, new SecureRandom()).modPow(key.n, key.n*key.n)).mod(key.n*key.n)
  }
  def E(plainText: BigInt): BigInt = encrypt(plainText: BigInt)

  def decrypt(c: BigInt): BigInt = {
    c * c.mod(key.n).modPow(key.d, key.n)
  }

  def L(u: BigInt) = {
    (u - 1)*key.n.modInverse()
  }

}

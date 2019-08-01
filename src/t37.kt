import java.math.BigInteger

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-07-27
 */

/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously
remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly
we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.*/

fun shiftVariations(value: BigInteger): List<BigInteger> {
    val left = value.toString().mapIndexed { i, _ -> value.toString().drop(i + 1) }
    val right = value.toString().mapIndexed { i, _ -> value.toString().dropLast(i + 1) }
    return (left + right).filter { it != "" }.map { BigInteger.valueOf(it.toLong()) }.plus(value)
}

fun isTruncatablePrime(value: BigInteger): Boolean {
    return shiftVariations(value).map { it.isProbablePrime(5) }.all { it }
}

fun main(args: Array<String>) { //    var prime = BigInteger.valueOf(7L)
    var prime = BigInteger.valueOf(7L)
    val accum = mutableListOf<Long>()
    while (accum.size < 11) {
        prime = prime.nextProbablePrime()
        if (isTruncatablePrime(prime)) {
            accum.add(prime.toLong())
            println("+ $prime, ${11 - accum.size} left")
        }
    }
    println("Sum: ${accum.sum()}")
}


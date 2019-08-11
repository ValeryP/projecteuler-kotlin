import java.math.BigInteger

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-11
 */
fun main() {
    println((2..1000000L).asSequence().filter {
        it % 2 == 1L && !BigInteger.valueOf(it).isProbablePrime(
            5
        )
    }.first { num ->
        !generatePrimes(num).map { prime ->
            (1..num).map { s ->
                prime.longValueExact() + 2L * s * s == num
            }.any { it }
        }.any { it }
    })
}

fun generatePrimes(it: Long): MutableList<BigInteger> {
    var prime = BigInteger.valueOf(2)
    val accum = mutableListOf(prime)
    val itBi = BigInteger.valueOf(it)
    while (prime < itBi) {
        prime = prime.nextProbablePrime()
        accum.add(prime)
    }
    return accum
}

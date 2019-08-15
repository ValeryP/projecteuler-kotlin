import java.math.BigInteger

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-11
 */

fun findPrimeFactorsPairs(value: Long, primes: Sequence<BigInteger>): MutableSet<Set<BigInteger>> {
    val valueB = BigInteger.valueOf(value)
    val value0 = BigInteger.valueOf(0)
    val primeFactors = primes.takeWhile { it <= valueB }.filter { valueB % it == value0 }
    val primeFactorsPairs = mutableSetOf<Set<BigInteger>>()
    for (p1 in primeFactors) {
        if (p1 > valueB) break
        for (p2 in primeFactors) {
            if (p1 * p2 > valueB) break
            for (p3 in primeFactors) {
                if (p1 * p2 * p3 > valueB) break
                for (p4 in primeFactors) {
                    val m4 = p1 * p2 * p3 * p4
                    if (m4 > valueB) break
                    val s = setOf(p1, p2, p3, p4)
                    if (s.size == 4 && (m4 == valueB || m4 * p1 == valueB || m4 * p2 == valueB || m4 * p3 == valueB || m4 * p4 == valueB)) {
                        primeFactorsPairs.add(s)
                    }
                }
            }
        }
    }
    return primeFactorsPairs
}

fun main() {
    val primes = generatePrimes(10000L).asSequence()
    val value = (100..1000000L).asSequence().first {
        if (it % 10000L == 0L) println("${it / 10000}%")
        val fn1 = findPrimeFactorsPairs(it, primes)
        val fn2 = findPrimeFactorsPairs(it + 1, primes)
        val fn3 = findPrimeFactorsPairs(it + 2, primes)
        val fn4 = findPrimeFactorsPairs(it + 3, primes)
        val result =
            fn1.isNotEmpty() && fn2.isNotEmpty() && fn3.isNotEmpty() && fn4.isNotEmpty() && fn1.minus(
                fn2
            ).minus(fn3).minus(fn4).isNotEmpty()
        result
    }
    println("$value: ${findPrimeFactorsPairs(value, primes)}")
}
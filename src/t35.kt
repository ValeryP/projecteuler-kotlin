import java.math.BigInteger

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-07-27
 */
fun variate(n: Int): MutableSet<Int> {
    var ns = n.toString()
    val accum = mutableSetOf<Int>()
    for (i in 0 until ns.length) {
        ns = ns.drop(1) + ns[0]
        accum.add(ns.toInt())
    }
    return accum
}

private fun isCircularPrime(i: Int) =
    variate(i).map { BigInteger.valueOf(it.toLong()).isProbablePrime(5) }.all { it }

fun main() {
    print((0..1000000).filter { isCircularPrime(it) }.count())
}


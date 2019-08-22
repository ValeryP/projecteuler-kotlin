import java.math.BigInteger
import kotlin.math.abs

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-16
 */


@Suppress("DuplicatedCode")
fun permutate(value: Int): MutableSet<Int> {
    val accum = mutableSetOf<Int>()
    fun premute(pref: String, text: String) {
        if (text.isEmpty()) {
            accum.add(pref.toInt())
        } else {
            for (i in 0 until text.length) {
                val newPref = pref + text[i]
                val newText = text.slice(0 until i).plus(text.slice(i + 1 until text.length))
                premute(newPref, newText)
            }
        }
    }
    premute("", value.toString())
    return accum
}

private fun getIncreasingSequence(it: List<Int>): List<Set<Int>> {
    val acc = mutableMapOf<Int, Set<Int>>()
    for (x in 0 until it.size - 1) {
        for (y in x + 1 until it.size - 1) {
            val diff = abs(it[x] - it[y])
            for (z in y + 1 until it.size - 1) {
                if (diff == abs(it[z] - it[y])) {
                    acc[diff] = setOf(it[x], it[y], it[z])
                }
            }
        }
    }
    return acc.values.filter { it.size == 3 }
}

fun main() {
    val primes =
            generatePrimes(9999L).filter { it > BigInteger.valueOf(1000) }.map { it.intValueExact() }
    val result = primes.asSequence()
            .map { permutate(it).filter { permutation -> primes.contains(permutation) } }
            .filter { it.size >= 3 }.map { getIncreasingSequence(it) }.filter { it.isNotEmpty() }.last()
            .first()
    println(result.toSortedSet().joinToString(""))
}

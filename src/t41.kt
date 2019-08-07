import java.math.BigInteger

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-07-27
 */

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly
once. For example, 2143 is a 4-digit pandigital and is also prime.
What is the largest n-digit pandigital prime that exists?
*/

fun permutateUntil(size: Int): MutableList<Long> {
    val accum = mutableListOf<Long>()

    fun premute(pref: String, text: String) {
        if (text.isEmpty()) {
            accum.add(pref.toLong())
        } else {
            for (i in 0 until text.length) {
                val newPref = pref + text[i]
                val newText = text.slice(0 until i).plus(text.slice(i + 1 until text.length))
                premute(newPref, newText)
            }
        }
    }

    premute("", (1 until size).joinToString(""))
    return accum
}

fun main() {
    for (i in 10 downTo 2) {
        val largestPP =
            permutateUntil(i).reversed().find { BigInteger.valueOf(it).isProbablePrime(5) }
        println("$i: ${largestPP ?: "-"}")
    }
}

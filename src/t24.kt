/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-07-26
 *
 * https://projecteuler.net/problem=24
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation
 * of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
   012   021   102   120   201   210
   What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
   *
   * Answer: 2783915460
 */

fun main() {
    val acum = mutableMapOf<Int, String>()

    fun premute(pref: String, text: String) {
        if (text.isEmpty()) {
            acum[acum.size] = pref
        } else {
            for (i in 0 until text.length) {
                val newPref = pref + text[i]
                val newText = text.slice(0 until i).plus(text.slice(i + 1 until text.length))
                premute(newPref, newText)
            }
        }
    }

    premute("", (0..9).toList().joinToString(""))
    print(acum.values.sorted()[999999])
}

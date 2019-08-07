/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-07-27
 */

fun main() {
    val concatenation = (1..1000000).joinToString("")
    (1..6).fold(listOf(1)) { accum, _ -> accum.plus(accum.last() * 10) }
        .map { concatenation[it - 1].toString().toInt() }.reduce { accum, v -> accum * v }
        .also { println(it) }
}

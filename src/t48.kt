import java.math.BigInteger

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-16
 */
fun main() {
    println(
        (1..1000L).asSequence().map { BigInteger.valueOf(it) }.reduce { acc, i -> acc + i.pow(i.intValueExact()) }.toString().takeLast(
            10
        )
    )
}
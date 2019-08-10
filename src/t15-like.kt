import java.math.BigInteger

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-10
 */

fun factorial(value: Long): BigInteger {
    return (1..value).map { BigInteger.valueOf(it) }.reduce { acc, i -> acc * i }
}

// notes: https://take.ms/KJM1Z
fun main() {
    val factorial20 = factorial(20)
    val factorial40 = factorial(40)
    println(factorial40 / (factorial20 * factorial20))
}
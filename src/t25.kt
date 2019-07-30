import java.math.BigInteger
import kotlin.math.ln
import kotlin.system.measureTimeMillis

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-07-27
 */


fun main(args: Array<String>) {
    println(measureTimeMillis {

        val factor = ln(2.0) / ln(10.0)

        fun getDigitCount(number: BigInteger): Int {
            val digitCount = (factor * number.bitLength() + 1).toInt()
            return if (BigInteger.TEN.pow(digitCount - 1) > number) {
                digitCount - 1
            } else digitCount
        }

        var x: BigInteger = BigInteger.valueOf(1)
        var y: BigInteger = BigInteger.valueOf(1)
        var c: Long = 2
        while (getDigitCount(y) < 1000) {
            val next = x + y
            x = y
            y = next
            c++
        }
        println(c)
    })
}
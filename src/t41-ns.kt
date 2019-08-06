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

import java.math.BigInteger

fun main() {
    var progress = 0L
    for (i in 9999999999 downTo 2143) {
        val s = i.toString().toCharArray()
        if (i % 2 != 0L && !s.contains('0') && s.size == s.toSet().size) {
            if (BigInteger.valueOf(i).isProbablePrime(5)) {
                println(i)
                break
            }
        }
    }
}

/*We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly
once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier,
and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1
through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your
sum.*/

fun checkMultipliers(value: Long): Long? {
    val vStr = value.toString()
    val n = vStr.length
    for (i in 1 until n) {
        for (j in i + 1 until n) {
            val m1 = vStr.slice(0 until i).toLong()
            val m2 = vStr.slice(i until j).toLong()
            val r = vStr.slice(j until n).toLong()
            if (m1 * m2 == r) {
                return r
            }
        }
    }
    return null
}

fun main() {
    println(permutateUntil(10).map { checkMultipliers(it) }.toSet().filterNotNull().sum())
}

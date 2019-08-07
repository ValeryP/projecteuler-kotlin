/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits
0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

- d2d3d4=406 is divisible by 2
- d3d4d5=063 is divisible by 3
- d4d5d6=635 is divisible by 5
- d5d6d7=357 is divisible by 7
- d6d7d8=572 is divisible by 11
- d7d8d9=728 is divisible by 13
- d8d9d10=289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.
*/

fun main() {
    fun matchPropertyCheck(value: Long): Boolean {
        val vString = value.toString()
        return if (vString.length != 10) false else emptySet<Boolean>().toMutableSet().apply {
            add(vString.slice(2 - 1 until 4).toInt().rem(2) == 0)
            add(vString.slice(3 - 1 until 5).toInt().rem(3) == 0)
            add(vString.slice(4 - 1 until 6).toInt().rem(5) == 0)
            add(vString.slice(5 - 1 until 7).toInt().rem(7) == 0)
            add(vString.slice(6 - 1 until 8).toInt().rem(11) == 0)
            add(vString.slice(7 - 1 until 9).toInt().rem(13) == 0)
            add(vString.slice(8 - 1 until 10).toInt().rem(17) == 0)
        }.all { it }
    }
    println(permutateUntil(10, true).filter { matchPropertyCheck(it) }.sum())
}

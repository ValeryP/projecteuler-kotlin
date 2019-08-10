// Eng rules: https://www.languagesandnumbers.com/how-to-count-in-english/en/eng/
fun main() {
    val numerals = hashMapOf(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty",
        60 to "sixty",
        70 to "seventy",
        80 to "eighty",
        90 to "ninety",
        100 to "hundred",
        1000 to "thousand"
    )

    fun pronounceNumber(value: Int): String {
        val div1000 = value / 1000
        val div100 = (value - div1000 * 1000) / 100
        val div10 = (value - div1000 * 1000 - div100 * 100) / 10
        val div1 = value - div1000 * 1000 - div100 * 100 - div10 * 10
        val thousand = if (div1000 > 0) "${numerals[div1000]} ${numerals[1000]}" else ""
        val hundred = if (div100 > 0) "${numerals[div100]} ${numerals[100]}" else ""
        val and = if (div1000 + div100 > 0 && div10 + div1 > 0) "and" else ""
        val dozen = when (div10) {
            1 -> numerals[div10 * 10 + div1]
            in 2..9 -> numerals[div10 * 10]
            else -> ""
        }!!
        val single = if (div1 > 0 && div10 != 1) "${numerals[div1]}" else ""
        return listOf(thousand, hundred, and, dozen, single).filter { it != "" }.joinToString(" ")
    }
    println((1..1000).map { pronounceNumber(it).replace(" ", "").length }.sum())
}



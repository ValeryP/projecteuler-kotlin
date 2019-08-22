/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 8/22/19
 */
class T33 {
    init {
        main()
    }

    fun main() {
        (10..99).forEach { i ->
            (i..99).forEach { j ->
                val num1Part1 = i.toString()[0].toString().toInt()
                val num1Part2 = i.toString()[1].toString().toInt()
                val num2Part1 = j.toString()[0].toString().toInt()
                val num2Part2 = j.toString()[1].toString().toInt()
                val res1 = i / j.toDouble()
                val res2 = num1Part1 / num2Part2.toDouble()
                if (res2 == res1 && num1Part2 == num2Part1 && num1Part1 != num2Part2) {
                    println("$i/$j=$res1, $num1Part1/$num2Part2=$res2")
                }
            }
        }
    }
}

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 3/18/18
 */


fun main(args: Array<String>) {
//    var i = 1
//    while (factorsNumber(i).size < 500) {
//        i++
//        println(i)
//    }
    println(factorsNumber(28).size)
}

// https://www.mathsisfun.com/numbers/factors-all-tool.html
fun factorsNumber(number: Int): Set<Int> {
    val smaller = arrayListOf(1)
    val bigger = arrayListOf(number)
    var nextSmall = smaller.last()
    while (bigger.last() - smaller.last() > 1) {
        nextSmall++
        if (nextSmall >= bigger.first()) {
            break
        }
        for (nextBig in (bigger.first() - 1) downTo nextSmall) {
            if (nextBig < 0) {
                return smaller.plus(bigger.reversed()).toSet()
            }
            if (nextSmall * nextBig == number) {
                smaller.add(nextSmall)
                bigger.add(nextBig)
                break
            } else {
                continue
            }
        }
    }
    return smaller.plus(bigger.reversed()).toSet()
}

fun triangleNumberFrom(i: Int): Int {
    var acum = 0
    for (n in 0..i) {
        acum += n
    }
    return acum
}
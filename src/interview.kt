import kotlin.math.pow

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 4/1/18
 */

fun main(args: Array<String>) { //    println(egg(100, 8))
    //    findBestDelta() //    print(first("Zsd"))
    //    println(pointInCircle(20.0, 0.0, 0.0, 14.0, 14.0))
    premutate("ABC")
}

private fun premutate(s: String) {
    fun premute(pref: String, text: String) {
        if (text.isEmpty()) {
            println(pref)
        } else {
            for (i in 0 until text.length) {
                val newPref = pref + text[i]
                val newText = text.slice(0 until i).plus(text.slice(i + 1 until text.length))
                premute(newPref, newText)
            }
        }
    }
    premute("", s)
}

fun first(a: String): Boolean = a.isNotEmpty() && a.toCharArray()[0].toInt() in 65..90

fun pointInCircle(radius: Double, Cx: Double, Cy: Double, Px: Double, Py: Double): Boolean =
    (Px - Cx).pow(2.0) + (Py - Cy).pow(2.0) <= radius * radius

fun findBestDelta() {
    for (i in 1..100) {
        var max: Pair<Int, Int> = (0 to 0)
        for (j in 1..100) {
            val eggDrops = egg(j, i)
            if (eggDrops > max.second) max = (i to eggDrops)
        }
        println(max)
    }
}

fun egg(x: Int, delta: Int): Int {
    var steps = 0
    for (i in delta..100 step delta) {
        steps++
        when {
            i >= x -> {
                val start = if (i - delta <= 0) 1 else i - delta + 1
                for (j in start + 1..i) {
                    steps++
                    if (j >= x) return steps
                }
            }
            i >= 100 - delta -> {
                for (j in i + 1..100) {
                    steps++
                    if (j >= x - 1) return steps
                }
            }
        }
    }
    return steps
}
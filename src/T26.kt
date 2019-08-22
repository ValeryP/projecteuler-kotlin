/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 8/17/19
 */
@Suppress("MemberVisibilityCanBePrivate")
class T26 {
    init {
        main()
    }

    fun preciseDiv(b: Int): String {
        val acc = mutableListOf<Int>()
        var a = 1
        for (i in 1..2000) {
            val num = a * 10
            val denom = num / b * b
            val div = if (denom == 1) b else denom
            acc.add(div / b)
            a = num - div
        }
        return acc.joinToString("")
    }

    fun main() {
        val repetition = "(\\d{7,})\\1".toRegex()
        println((2..1000).asSequence().map {
            var result = ""
            val divFull = preciseDiv(it)
            var match = repetition.findAll(divFull).map { matchResult -> matchResult.groupValues }.lastOrNull()?.last()
            while (match != null) {
                result = match
                match = repetition.findAll(match).map { matchResult -> matchResult.groupValues }.lastOrNull()?.last()
            }
            Pair(it,result)
        }.maxBy { it.second.length })
    }
}

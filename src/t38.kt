/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-11
 */
fun main() {
    val acc = mutableMapOf<Long, String>()
    for (i in 1..333333333L) {
        var concatAccum = i.toString()
        for (n in 2..9) {
            if (concatAccum.length > 9) {
                break
            } else if (concatAccum.length == 9 && concatAccum.replace("0", "").toSet().size == 9) {
                acc[i] = concatAccum
            }
            concatAccum += n * i
        }
    }
    println(acc.entries.maxBy { it.value })
}
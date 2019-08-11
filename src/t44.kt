/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-11
 */
fun main() {
    val numbers = (1..10000).map { n -> n * (3 * n - 1) / 2 }.toHashSet()
    for (j in numbers) {
        for (k in numbers) {
            if (numbers.contains(j + k) && numbers.contains(j - k)) println("$j, $k = ${j - k}")
        }
    }
}
/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-11
 */
fun main() {
    val triangles = (286..1000000L).map { n -> n * (n + 1) / 2 }
    val pentagonals = (1..1000000L).map { n -> n * (3 * n - 1) / 2 }.toHashSet()
    val hexagonals = (1..1000000L).map { n -> n * (2 * n - 1) }.toHashSet()
    println(triangles.first { pentagonals.contains(it) && hexagonals.contains(it) })
}
import java.io.File

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-11
 */


fun main() {
    val triangles = (1..26 * 14).map { 0.5 * (it * (it + 1)) }.map { it.toInt() }
    val words = File("src/p042_words.txt").readText().split(",").map { it.replace("\"", "") }
    println(words.map { word ->
        word.toCharArray().map { it.toInt() - 64 }.sum()
    }.filter { triangles.contains(it) }.count())
}

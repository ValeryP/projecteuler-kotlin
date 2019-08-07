/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-03
 */

/*
* If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
* there are exactly three solutions for p = 120.
{20,48,52}, {24,45,51}, {30,40,50}
For which value of p ≤ 1000, is the number of solutions maximised?
*
* Rulse:
*   - BC>AC, BC>AB
*   - AC^2 +AB^2 = BC^2
* */
fun main() {
    val accum = hashMapOf<Int, Int>()
    for (p in 3 until 1000) {
        for (c in 3 until p) {
            for (b in 3 until p - c) {
                val a = p - c - b
                if (a >= c || b >= c || a * a + b * b != c * c) continue
                accum[p] = accum.getOrDefault(p, 0) + 1
            }
        }
    }
    println(accum.entries.maxBy { it.value }!!.key)
}
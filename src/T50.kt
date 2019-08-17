/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 8/17/19
 */
class T50 {
    init {
        main()
    }

    fun main() {
        val primes = generatePrimes(1000000L).map { it.intValueExact() }
        val result = mutableMapOf<Int, Pair<Int, List<Int>>>()
        for (i in 0 until primes.size - 1) {
            for (j in i + 1 until primes.size - 1) {
                val slice = primes.slice(i..j)
                val sum = slice.sum()
                if (sum > 1000000L) break
                if (primes.contains(sum)) result[slice.size] = Pair(sum, slice)
            }
        }
        println(result.entries.maxBy { it.key })
    }
}

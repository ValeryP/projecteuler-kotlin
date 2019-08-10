import java.util.*

/*
 * @author Valeriy Palamarchuk
 * @email valeriij.palamarchuk@gmail.com
 * Created on 2019-08-10
 */

fun main() {
    Calendar.getInstance().run {
        println((1901..2000).map { year ->
            (1..12).map { month ->
                this.set(year, month, 1)
                this.get(Calendar.DAY_OF_WEEK)
            }.filter { it == 1 }
        }.flatten().sum())
    }
}
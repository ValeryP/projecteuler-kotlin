fun main() {
    var acc = 0
    var i = 1
    while ((1..acc).count { acc % it == 0 } < 500) {
        acc += i
        i++
    }
    println(acc)
}
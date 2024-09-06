fun main() {
    // 주사위를 던져서 몇번만에 21을 초과하는가?
    var sum = 0
    var count = 0
    while (sum <= 21) {
        val dice = Math.ceil(Math.random() * 6).toInt()
        sum += dice
        count++
        print("$dice ")
    }
    println()
    println("$sum, $count")
    
    sum = 0; count = 0
    while (true) {
        val dice = Math.ceil(Math.random() * 6).toInt()
        sum += dice
        count++
        print("$dice ")
        if (sum > 21)
        	break
    }
    println()
    println("$sum, $count")
    
    sum = 0; count = 0
    do {
        val dice = Math.ceil(Math.random() * 6).toInt()
        sum += dice
        count++
        print("$dice ")
    } while (sum <= 21)
    println()
    println("$sum, $count")
}
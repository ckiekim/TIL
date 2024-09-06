fun main() {
    // AnyPang
    for (i in 1..8) {
        for (k in 1..8) {
            print(Math.ceil(Math.random() * 6).toInt().toString()); print(" ")
        }
        println()
    }
    
    // 1사분면
	for (i in 1..5) {
        for (k in 1..i) {
            print("*")
        }
        println()
    }
    
    // 2사분면
    for (i in 1..5) {
        for (k in 1..5-i) {
            print(" ")
        }
        for (k in 1..i) {
            print("*")
        }
        println()
    }
    
    // 디지털 시계에서 하루동안 3이 표시되는 시간은 몇초인가?
    var seconds = 0
    for (hour in 0..23) {
        for (minute in 0..59) {
            val timeStr = "" + hour + ":" + minute
            if (timeStr.contains("3"))		// timeStr.indexOf("3") >= 0
            	seconds += 60
        }
    }
    print(seconds)
}
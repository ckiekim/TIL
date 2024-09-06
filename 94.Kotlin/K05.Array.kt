fun main() {
    val numbers = IntArray(4)
    numbers[0] = 135
    numbers.set(1, 268)
    println(numbers.get(0) + numbers[1])

    val longArray = LongArray(4)
    val charArray = CharArray(5)
    val doubleArray = DoubleArray(6)

    // 문자 배열
    val stringArray = Array(10, {item -> "A"})
    println(stringArray[0] + stringArray[1] + stringArray[2])

    // 값으로 배열공간 할당
    val dayArray = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
    println(dayArray.size)
    println(dayArray.contentToString())
}
fun main() {
    // List
    val list = mutableListOf("apple", "banana", "cherry")
    list.add("apple"); list.add("orange")
    println(list)
    println(list.size)
    println(list.javaClass.name)
    println("My favorite fruits are ${list[0]} and ${list.get(list.size - 1)}")
    list.removeAt(2)
    list.remove("banana")
    println(list)

    val DAY_LIST = listOf("일", "월", "화", "수", "목", "금", "토")	// immutable list
    println(DAY_LIST.javaClass.name)

    // set
    val divisors12 = mutableSetOf(1, 2, 3, 4, 6, 12)
    val divisors15 = setOf(1, 3, 5, 15)
    println(divisors12)
    println(divisors12.size)
    println(divisors12.javaClass.name)
    println(divisors12.union(divisors15))		// 합집합
    println(divisors12.intersect(divisors15))	// 교집합

    // map
    val env = mutableMapOf("OS" to "Windows_NT", "SystemDrive" to "C:")
    env.put("NUMBER_OF_PROCESSORS", "8")
    println(env)
    println(env.size)
    println(env.get("OS"))
}
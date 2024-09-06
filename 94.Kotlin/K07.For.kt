fun main() {
	for (i in 0..3)		// 0, 1, 2, 3
		print("$i ")
	println();
	for (i in 1..10 step 2)		// 1, 3, 5, 7, 9
		print("$i ")
	println();
	for (i in 10 downTo 1 step 2)	// 10, 8, 6, 4, 2
		print("$i ")
	println();
	
	val numbers = listOf(1, 3, 5, 7, 9)
	for (num in numbers)
		print("$num ")
	println();
	
	var sum = 0
	for (i in 1..100)
		sum += i
	println("sum = $sum")
	
	var str = ""
	for (i in 1..10)
		str += i
	println(str)
	
	val list = mutableListOf<Int>()
	for (i in 1..10)
		list.add(i)
	println(list)
}
fun main() {
	val dice1 = Math.ceil(Math.random() * 6).toInt()
	val DICE_RANGE = (1..6)
	val dice2 = DICE_RANGE.random()
	println("$dice1, $dice2")

	val sum = dice1 + dice2
	if (sum % 2 == 0)
		println("sum is even number")
	else
		println("sum is odd number")

	if (sum >= 9)
		println("9 <= sum")
	else if (sum >= 5)
		println("5 <= sum < 9")
	else
		("sum < 5")

	// Nested if
	if (sum >= 9) {
		println("9 <= sum")
	} else {
		if (sum >= 5)
			println("5 <= sum < 9")
		else
			println("sum < 5")
	} 

	// 3항 연산자
	val msg = "sum is " + if (sum % 2 == 0) "even" else "odd"
	println(msg + " number")
	println("sum is ${if (sum % 2 == 0) "even" else "odd"} number")
}
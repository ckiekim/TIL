import java.time.LocalDate

fun main() {
	val input = "0009013"
	var seven = input[6]
	var bYear = input.substring(0, 2).toInt() + if (seven == '3' || seven == '4') 2000 else 1900
	var bMonth = input.substring(2, 4).toInt()
	var bDay = input.substring(4, 6).toInt()
	println("Birthday: ${LocalDate.of(bYear, bMonth, bDay)}")

	val today = LocalDate.now()
	var tYear = today.getYear()
	var tMonth = today.getMonth().getValue()
	var tDay = today.getDayOfMonth()
	println("Today:    $today")

	var age = tYear - bYear
	age -= if (tMonth < bMonth || (tMonth == bMonth && tDay < bDay)) 1 else 0
	println("age is $age")
}

fun main() {
    val num = 4
    if (isEven(num))
    	println("$num is even number")
    else
    	println("$num is odd number")
        
	consumer("apple")
    consumer(producer().toString())
    
    for (i in 91..99) {
        for (k in i..99) {
            val product = i * k
            if (isPalindrome(product.toString()))
            	println("$i * $k = $product is palindrome number")
        }
    }
}

fun isEven(num: Int): Boolean {		// num 앞에 val 이 생략되었음, call-by-value
    return num % 2 == 0
}

fun consumer(str: String) {
    println("=== $str ===")
}

fun producer(): Int {
    return Math.ceil(Math.random() * 100).toInt()
}

fun isPalindrome(str: String): Boolean {
    return str == str.reversed()
}
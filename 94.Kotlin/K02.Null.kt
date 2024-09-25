/*
 * Kotlin은 기본적으로 null 값을 허용하지 않으며, 이를 통해 NullPointerException(NPE)을 방지함
 */

fun main() {
	// 1. Nullable 타입 (? 사용)
	var nonNullableString: String = "Hello"		// null 불가능
	var nullableString: String? = null			// 타입 뒤에 ?가 붙어 있으면 null 가능
	println("${nonNullableString}, ${nullableString}")

	// 2. Safe Call (?. 사용)
	val length1: Int? = nullableString?.length	// nullableString이 null이면 length는 null
	println("length1 = ${length1}")

	// 3. Elvis 연산자 (?: 사용)
	val length2: Int = nullableString?.length ?: 0	// nullableString이 null이면 기본값으로 지정한 0 반환
	println("length2 = ${length2}")

	// 4. Non-null Assertion (!! 사용) - 강제로 변수를 non-null 타입으로 변환
	try {
		val length3: Int = nullableString!!.length		// nullableString이 null이면 NPE 발생
		println("length3 = ${length3}")
	} catch(e: NullPointerException) {
		println("NullPointerException 발생")
	}

	// 5. let 함수 사용
	nullableString?.let { 
		println(it.length)  // nullableString이 null이 아닐 때만 실행
	}

	// 6. isNullOrEmpty 및 isNullOrBlank 함수
	val isEmpty = nullableString.isNullOrEmpty()  // null이거나 빈 문자열이면 true 반환
	println("isEmpty = ${isEmpty}")
	val isBlank = nonNullableString.isNullOrBlank()  // null이거나 빈 문자열이면 true 반환
	println("isBlank = ${isBlank}")
}

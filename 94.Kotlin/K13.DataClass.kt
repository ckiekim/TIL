/*
 * Data Class
	- 다양한 메소드를 자동으로 생성(hashCode, copy, equals, toString, componentsN)
	- 기본 생성자에 1개 이상의 파라미터가 있어야 함
	- 기본 생성자의 파라미터가 val 또는 var 로 선언되어야 함
	- 다른 클래스를 상속받을 수 없음
 */

 fun main() {
	val p1 = People("James", 28)
	println(p1.toString())

	val p2 = People("Maria", 24)
	val p3 = People("James", 28)
	println("hash code: p1 = ${p1.hashCode()}, p2 = ${p2.hashCode()}")
	println("equals: p1.equals(p2) = ${p1.equals(p2)}, p1.equals(p3) = ${p1.equals(p3)}")
	println("equals: p1 == p2 = ${p1 == p2}, p1 == p3 = ${p1 == p3}")

	// Destructuring
	val (name, age) = p1	// val name = p1.component1(); val age = p1.component2()
	println("name = $name, age = $age")
 }

 data class People(val name: String, val age: Int)

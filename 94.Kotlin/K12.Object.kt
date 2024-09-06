fun main() {
	Person.name = "James"
	Person.age = 25
	println(Person)

	// 2. 익명 객체
	val obj = object{
		var name: String = ""
		var age: Int = 0
		override fun toString(): String {
			return "Anonymous class: name = $name, age = $age"
		}
	}
	obj.name = "James"
	obj.age = 25
	println(obj)

	val s1 = Student("James", 17)
	val s2 = Student("Maria", 16)
	println(s1)
	println(s2)
	println(Student.School.name)
}

// 1. 객체 선언 - Singleton 패턴(객체가 단 하나 존재하는 클래스)
object Person {
	var name: String = ""
	var age: Int = 0
	override fun toString(): String {
		return "Person: name = $name, age = $age"
	}
}

// 3. 동반 객체(companion object)
// 		- 클래스의 모든 객체가 공유하는 속성, 메소드
//		- 접근은 객체를 통해서가 아니라 클래스를 통해서 해야 함
class Student(var name: String, var age: Int) {
	companion object School {
		val name = "First High School"
	}
	override fun toString(): String {
		return "Student: name = $name, age = $age"
	}
}
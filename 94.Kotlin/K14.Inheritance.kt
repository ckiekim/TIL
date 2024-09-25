/*
 * 상속(Inheritance)
	- 공통의 조상: Any (Java의 Object와 유사, equals(), hashCode(), toString() 만 가짐)
	- Parent class: open(public 의미) 
	- Child class: override
 */

fun main() {
	val e = Employee("Good Company")
	e.work()

	val s = Student("First High School", "James", 17)
	s.introduce()
	s.sayHello()
}

open class People(open val name: String, open val age: Int) {
	fun sayHello() {
		println("Hello, everyone! I'm $name")
	}
}

class Employee(val companyName: String) : People("Maria", 25) {
	fun work() {
		super.sayHello()
		println("I'm working at $companyName.")
	}
}

class Student(val schoolName: String, name: String, override val age: Int) : People(name, age) {
	fun introduce() {
		println("I'm $name, a student of $schoolName and $age years old.")
	}
}

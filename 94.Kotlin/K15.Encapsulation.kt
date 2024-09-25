fun main() {
	val dog = Dog()
	dog.sound()
	dog.setAge(3)
	println(dog.getAge())
}

open class Animal {
	private var age: Int = 0
	open fun sound() {
		println("Animal sound")
	}
	fun setAge(age: Int) {		// 접근 제한자를 생략하면 public
		this.age = age
	}
	fun getAge(): Int {
		return this.age
	}
}

class Dog: Animal() {
	override fun sound() {
		println("Bark")
	}
}
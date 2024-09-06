fun main() {
    val person = Person()   // 생성자가 없으므로 Person("James", 35)는 불가, new keyword 없음
    person.name = "James"; person.age = 32
    println("${person.name}, ${person.age}")

    val p = Person1("James", 35)
    val q = Person1("Maria", 28)
    println(p)
    println(q)
    println(Person2("James", 35))
    println(Person2("Maria", 28))
    println(Person3("James", 35))
    println(Person3("Maria", 28))
    
    val p41 = Person4(); println("Person4: name = ${p41.name}, age = ${p41.age}")
    val p42 = Person4("James"); println("Person4: name = ${p42.name}, age = ${p42.age}")
    val p43 = Person4("Maria", 25); println("Person4: name = ${p43.name}, age = ${p43.age}")
    val p44 = Person4(age=33, name="James"); println("Person4: name = ${p44.name}, age = ${p44.age}")
    
    println("${Person5()}\n${Person5("James")}\n${Person5("Maria", 25)}")
}

// 클래스 선언, 속성은 선언과 동시에 초기화해주어야 함
class Person {
	var name: String = ""
    var age: Int = 0
}

// 생성자 - 다음 세개는 동일한 결과
class Person1 {
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
    var name: String = ""
    var age: Int = 0
    override fun toString(): String {
        return "Person1: name = $name, age = $age"
    }
}
class Person2 constructor(name: String, age: Int) {
    var name: String = name
    var age: Int = age
    override fun toString(): String {
        return "Person2: name = $name, age = $age"
    }
}
class Person3(name: String, age: Int) {
    var name: String = name
    var age: Int = age
    override fun toString(): String {
        return "Person3: name = $name, age = $age"
    }
}

// 클래스 속성이 파라메터 영역으로, 기본값 설정으로 인해 생성자 overloading이 필요없음
// 자바와 비교해 매우 간결해졌음
class Person4(var name: String = "James", var age: Int = 30)

class Person5(var name: String = "James", var age: Int = 30) {
    override fun toString(): String {
        return "Person5: name = $name, age = $age"
    }
}
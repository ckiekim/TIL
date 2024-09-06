fun main() {
   	var score = 50 + Math.ceil(Math.random() * 50).toInt()
    var grade: Char
    
    when(score) {
        in 90..100 -> println("score: $score, grade: A")
        in 80..89 -> println("score: $score, grade: B")
        in 70..79 -> println("score: $score, grade: C")
        in 60..69 -> println("score: $score, grade: D")
        else -> { println("score: $score, grade: F"); println("Is it possible?") }
    }
    
    grade = when(score) {
        in 90..100 -> 'A'
        in 80..89 -> 'B'
        in 70..79 -> 'C'
        in 60..69 -> 'D'
        else -> 'F'
    }
    println("score: $score, grade: $grade")
}
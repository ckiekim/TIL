fun main() {
	val ll = mutableListOf<String>();
	ll.add("a")
	ll.add("b")
	ll.add("c")
	ll.add("d")
	ll.add("e")

	for(item in ll.subList(0,3))
		println(item)
}
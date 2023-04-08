package minesweeper

fun inputValidator(): MutableList<String> {
    val input = mutableListOf<String>()
    var flag = false
    while (!flag) {
        println("Set/unset mines marks or claim a cell as free:")
        val (b, a, str: String) = readln().split(" ")
        flag = b.toInt() in 1 ..FIELD_SIZE &&
                a.toInt() in 1 .. FIELD_SIZE &&
                str == "free" || str == "mine"
        if (!flag){
            println("Incorrect input! Your input must be like > 1 1 free/mine")
        } else {
            input.add(a)
            input.add(b)
            input.add(str)
        }
    }
    return input
}
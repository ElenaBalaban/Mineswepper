package minesweeper

open class Field {
    val field = MutableList(FIELD_SIZE) { MutableList(FIELD_SIZE) { "." } }

    fun print() {
        println()
        println(" │123456789│")
        println("—│—————————│")
        for (i in 0 until FIELD_SIZE) {
            println("${i + 1}│${field[i].joinToString("")}│")
        }
        println("—│—————————│")
    }

    fun minesQuantity(): Int{
        var c = 0
        for (i in 0 until FIELD_SIZE) {
            for (j in 0 until FIELD_SIZE) {
                when {
                    this.field[i][j] === "*" -> c++
                }
            }
        }
        return c
    }
}
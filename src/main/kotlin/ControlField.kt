package minesweeper

import java.util.*

class ControlField(minesQuantity: Int): Field(){
    private var mines = minesQuantity

    init {
        while (mines !in 0.. FIELD_SIZE * FIELD_SIZE){
            println("The field is limited, please enter a number from 0 to 81")
            mines = readln().toInt()
        }
        for (i in 0 until mines) {
            var x: Int
            var y: Int
            do {
                x = Random().nextInt(0, FIELD_SIZE)
                y = Random().nextInt(0, FIELD_SIZE)
            } while (field[x][y] == "*")
            field[x][y] = "*"
        }
        for (x in 0 until field.size) {
            for (y in 0 until field[0].size) {
                if (field[x][y] != "*") {
                    val count = countMinesAround(x, y)
                    if (count!=0) field[x][y] = count.toString()
                }
            }
        }
    }

        fun countMinesAround(x: Int, y: Int): Int {
        var count = 0
        for (i in (x - 1)..(x + 1)) {
            for (j in (y - 1)..(y + 1)) {
                if ((i in 0 until FIELD_SIZE) && (j in 0 until FIELD_SIZE) && (field[i][j] == "*")) {
                    count++
                }
            }
        }
        return count
    }
}
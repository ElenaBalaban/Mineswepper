package minesweeper

class PlayingField : Field() {

    fun playInField(controlField: ControlField) {
        var repeat = true

        while (repeat) {
            val input = inputValidator()
            val x = input[0].toInt() - 1
            val y = input[1].toInt() - 1
            val str = input[2]

            if (controlField.field[x][y] == "*" && str == "free") {
                repeat = false
                this.print()
                println("You stepped on a mine and failed!")
            } else {
                if (controlField.field[x][y] != "*" && str == "free") {
                    this.renameCell(controlField, x, y)
                    openArea(controlField)
                } else if (str == "mine") {
                    when{
                        this.field[x][y] == "*" -> this.field[x][y] = "."
                        this.field[x][y] != "*" -> this.field[x][y] = "*"
                    }
                }
                val compareMinesQuantity = controlField.minesQuantity() == this.minesQuantity()

                if (compareFields(controlField, this) && compareMinesQuantity) {
                    this.print()
                    println("Congratulations! You found all the mines!")
                    repeat = false
                } else if (!compareFields(controlField, this) && compareMinesQuantity) {
                    this.print()
                    println("You stepped on a mine and failed!")
                    repeat = false
                } else {
                    this.print()
                }
            }
        }
    }


    private fun openArea(controlField: ControlField) {
        var flag = true
        while (flag) {
            flag = false

            for (i in 0 until FIELD_SIZE) {
                for (j in 0 until FIELD_SIZE) {
                    if (controlField.countMinesAround(i, j) == 0 && this.field[i][j] != ".") {
                        this.renameCellAround(controlField, i, j)
                    }
                }
            }
            for (i in 0 until FIELD_SIZE) {
                for (j in 0 until FIELD_SIZE) {
                    if (controlField.countMinesAround(i, j) == 0 && this.field[i][j] != "." && !openCellAroundCheck(this, i, j)) {
                        flag = true
                    }
                }
            }
        }
    }

    private fun renameCell(controlField: ControlField, x: Int, y: Int) {
        this.field[x][y] = controlField.field[x][y]
        if (controlField.field[x][y] == ".") {
            this.field[x][y] = "/"
        } else {
            this.field[x][y] = controlField.field[x][y]
        }
    }

    private fun renameCellAround(controlField: ControlField, i: Int, j: Int) {
        for (k in (i - 1)..(i + 1)) {
            for (l in (j - 1)..(j + 1)) {
                if ((k in 0 until FIELD_SIZE) && (l in 0 until FIELD_SIZE)) {
                    this.renameCell(controlField, k, l)
                }
            }
        }
    }

    private fun openCellAroundCheck(playField: Field, x: Int, y: Int): Boolean {
        var flag = true
        for (i in (x - 1)..(x + 1)) {
            for (j in (y - 1)..(y + 1)) {
                if (i in 0 until FIELD_SIZE && j in 0 until FIELD_SIZE && playField.field[i][j] == ".") {
                    flag = false
                }
            }
        }
        return flag
    }
}
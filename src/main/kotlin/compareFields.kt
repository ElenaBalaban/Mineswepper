package minesweeper

fun compareFields(controlField: ControlField, playingField: PlayingField): Boolean {
    var flag = true
    for (x in 0 until controlField.field.size) {
        for (y in 0 until controlField.field[0].size) {
            when {
                controlField.field[x][y] != "*" && playingField.field[x][y] == "*" -> flag = false
                controlField.field[x][y] == "*" && playingField.field[x][y] != "*" -> flag = false
            }
        }
    }
    return flag
}
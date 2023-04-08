package minesweeper

const val FIELD_SIZE = 9

fun main() {
    print("How many mines do you want on the field?")

    val controlMinefield = ControlField(readln().toInt())
    val playingField = PlayingField()

    playingField.print()
    playingField.playInField(controlMinefield)
}
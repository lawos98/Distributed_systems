enum class TextColor(val code: String) {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    B_BLACK("\u001B[30m \u001B[40m"),
    B_RED("\u001B[30m \u001B[41m"),
    B_GREEN("\u001B[30m \u001B[42m"),
    B_YELLOW("\u001B[30m \u001B[43m"),
    B_BLUE("\u001B[30m \u001B[44m"),
    B_PURPLE("\u001B[30m \u001B[45m"),
    B_CYAN("\u001B[30m \u001B[46m"),
    B_WHITE("\u001B[30m \u001B[47m")
}

object ColorPrinter {
    fun printInColor(text: String, color: TextColor) {
        val colorCode = color.code
        val resetCode = TextColor.RESET.code
        println("$colorCode$text$resetCode")
    }
}
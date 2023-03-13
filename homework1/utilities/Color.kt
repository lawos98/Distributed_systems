package utilities

enum class Color {
    RED{
        override fun colorText(text: String): String {
            return "\u001B[31m$text\u001B[0m"
        }

       },
    GREEN{
        override fun colorText(text: String): String {
            return "\u001B[32m$text\u001B[0m"
        }
         },
    BLUE{
        override fun colorText(text: String): String {
            return "\u001B[34m$text\u001B[0m"
        }
        },
    YELLOW{
        override fun colorText(text: String): String {
            return "\u001B[33m$text\u001B[0m"
        }
    },
    PURPLE{
        override fun colorText(text: String): String {
            return "\u001B[35m$text\u001B[0m"
        }
    };

    abstract fun colorText(text:String): String
}
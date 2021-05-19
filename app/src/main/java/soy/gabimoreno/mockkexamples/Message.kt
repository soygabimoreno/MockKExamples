package soy.gabimoreno.mockkexamples

data class Message(
    val text: String,
    val code: Code
) {

    enum class Code {
        CODE_1,
        CODE_2
    }
}

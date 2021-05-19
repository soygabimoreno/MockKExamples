package soy.gabimoreno.mockkexamples

class Calculator(
    private val tracker: Tracker,
    private val logger: Logger
) {

    fun square(number: Int): Int {
        tracker.sendMessage(
            Message(
                text = "Calculating square of $number...",
                code = Message.Code.CODE_1
            )
        )
        val result = number * number
        logger.log("The square of $number is $result")
        return result
    }
}

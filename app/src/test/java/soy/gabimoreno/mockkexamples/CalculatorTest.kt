package soy.gabimoreno.mockkexamples

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.slot
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private val tracker: Tracker = spyk()
    private val logger: Logger = mockk(relaxed = true)
    private val calculator = Calculator(
        tracker,
        logger
    )

    @Before
    fun setup() {
        every { tracker.sendMessage(any()) } just runs
    }

    @Test
    fun `Square calculates the proper result`() {
        val result = calculator.square(2)

        assertTrue(4 == result)
    }

    @Test
    fun `WHEN square is called THEN logger is called`() {
        calculator.square(1234)

        verify(exactly = 1) { logger.log(any()) }
    }

    @Test
    fun `WHEN square is called THEN tracker sends a message`() {
        calculator.square(1234)

        verify(exactly = 1) { tracker.sendMessage(any()) }
    }

    @Test
    fun `WHEN square is called THEN tracker sends the right message`() {
        val number = 1234
        calculator.square(number)

        val slot = slot<Message>()

        verify(
            atLeast = 1,
            atMost = 1
        ) { tracker.sendMessage(capture(slot)) }

        val captured = slot.captured
        assertTrue(captured.text == "Calculating square of $number...")
        assertTrue(captured.code == Message.Code.CODE_1)
    }
}

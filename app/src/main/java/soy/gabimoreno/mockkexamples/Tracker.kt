package soy.gabimoreno.mockkexamples

import android.util.Log

class Tracker {

    companion object {
        private const val TAG = "Tracker"
    }

    fun sendMessage(message: Message) {
        Log.d(
            TAG,
            "text: ${message.text}, code: ${message.code}"
        )
    }

    fun sendCode(code: Int) {
        Log.d(
            TAG,
            "$code"
        )
    }
}

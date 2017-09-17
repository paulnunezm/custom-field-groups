package com.nunez.compoundedittext

import android.text.Editable
import android.text.TextWatcher

/**
 * This class is a helper for the EditTexts that
 * notifies when the widget has text or not.
 */
class CustomTextWatcher(
        val listener: (hasText: Boolean, textStateChanged: Boolean) -> (Unit)
) : TextWatcher {

    var previousStateHadText = false
    var currentStateHasText = false

    override fun afterTextChanged(p0: Editable?) {}

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(currentText: CharSequence?, p1: Int, p2: Int, count: Int) {

        // Check if the input has text
        currentStateHasText = (count > 0)

        // Check if the input has changed it state (has or not text)
        if (currentStateHasText == previousStateHadText) {
            listener(currentStateHasText, false)
        } else {
            listener(currentStateHasText, true)
            previousStateHadText = currentStateHasText
        }
    }
}
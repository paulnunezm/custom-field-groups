package com.nunez.compoundedittext

import android.text.Editable
import android.text.TextWatcher

/**
 * This class is a helper for the EditTexts that
 * notifies when the widget has text or not.
 */
class CustomTextWatcher (
        val listener: (hasText:Boolean) -> (Unit)
): TextWatcher {
    override fun afterTextChanged(p0: Editable?) {}

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(currentText: CharSequence?, p1: Int, p2: Int, count: Int) {

        if(count > 0)
            listener(true)
        else
            listener(false)
    }
}
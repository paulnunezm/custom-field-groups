package com.nunez.compoundedittext

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_field.view.*


class CustomField @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr){

    lateinit var textWatcher: CustomTextWatcher

    init {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_field, this)

        setClearListener()
    }

    fun setTextListener(textWatcher: CustomTextWatcher) {
        this.textWatcher = textWatcher
        customField_editText.addTextChangedListener(this.textWatcher)
    }

    fun removeTextListener(){
        customField_editText.removeTextChangedListener(textWatcher)
    }

    fun setHint(hint: String) {
        customField_editText.hint = hint
    }

    fun setClearListener(){
        // Clear the text when the x is clicked
        customField_clear.setOnClickListener {
            customField_editText.setText("")
        }
    }

    fun getFieldValue(): String = customField_editText.text.toString()
}

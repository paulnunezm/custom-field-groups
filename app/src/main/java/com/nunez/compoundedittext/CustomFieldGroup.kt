package com.nunez.compoundedittext

import android.animation.ObjectAnimator
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.custom_field_group.view.*

class CustomFieldGroup @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var fieldsArray = ArrayList<CustomField>()
    lateinit var textWatcher: CustomTextWatcher

    init {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_field_group, this)

        addNewBtn.visibility = View.GONE

        addNewBtn.setOnClickListener { addNewField() }

        // Add the first field
        initTexWatcherListener()
        addNewField()
    }

    fun showAddButton() {
        addNewBtn.visibility = View.VISIBLE
        addNewBtn.alpha = 0f
        val animation = ObjectAnimator.ofFloat(addNewBtn, "alpha", 1f)
        animation.duration = 500
        animation.start()
    }

    fun hideAddButton() {
        addNewBtn.visibility = View.GONE
    }

    fun addNewField() {
        hideAddButton()

        // Create a new field
        val field = CustomField(context)
        field.setHint("addresses")

        // Add it to the layout
        fields.addView(field)

        // Add it to the collection
        fieldsArray.add(field)

        setListenerToTheLastVisibleField()

        // Set focus to the new field if is not the first
        if(fieldsArray.size > 1) field.requestFocus()
    }

    fun initTexWatcherListener() {
        textWatcher = CustomTextWatcher {
            hasText, textStateChanged ->

            if (textStateChanged) {
                if (hasText)
                    showAddButton()
                else
                    hideAddButton()
            }
        }
    }

    fun setListenerToTheLastVisibleField() {
        if (fieldsArray.size == 1) {
            fieldsArray[0].setTextListener(textWatcher)
        } else {
            textWatcher.resetWatcher()
            fieldsArray[fieldsArray.size - 2].removeTextListener()
            fieldsArray[fieldsArray.size - 1].setTextListener(textWatcher)
        }
    }

    fun getFieldValues(): ArrayList<String> {
        val values = ArrayList<String>()
        fieldsArray.mapTo(values) { it.getFieldValue() }
        return values
    }
}

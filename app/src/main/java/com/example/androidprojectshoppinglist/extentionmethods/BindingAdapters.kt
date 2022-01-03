package com.example.androidprojectshoppinglist.extentionmethods

import androidx.databinding.BindingAdapter
import com.example.androidprojectshoppinglist.R
import com.example.androidprojectshoppinglist.model.FormValidationErrorModel
import com.example.androidprojectshoppinglist.model.FormValidationErrorTags
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("setFormValidationError")
fun TextInputEditText.setFormValidationError(errors: List<FormValidationErrorModel>?) {
    if (this.tag != null) {
        val tag: FormValidationErrorTags = FormValidationErrorTags.getType(this.tag.toString())
        val textInputLayout = this.parent.parent as? TextInputLayout

        if (errors?.map { it.tags }?.contains(tag).orFalse()) {
            val errorModel = errors?.find { it.tags == tag }
            textInputLayout?.error = errorModel?.message
            textInputLayout?.requestFocus()
            this.setCompoundDrawablesWithIntrinsicBounds(
                null,
                null,
                this.context.drawable(R.drawable.ic_error_18dp)
                    .apply { this?.setBounds(0, 0, this.intrinsicWidth, this.intrinsicHeight) },
                null
            )
        } else {
            this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            textInputLayout?.error = null
        }
    }
}
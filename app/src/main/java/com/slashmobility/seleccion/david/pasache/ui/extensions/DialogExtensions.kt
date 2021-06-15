package com.example.commons.ui.component.extensions

import android.app.Dialog
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.commons.ui.component.enums.DialogType
import com.example.commons.ui.model.button.ButtonModel
import com.slashmobility.seleccion.david.pasache.R

class DialogExtensions {

    companion object {

        fun Dialog.setup(
                type: DialogType,
                title: Int = 0,
                desc: Int = 0,
                buttonMdl1: ButtonModel? = null,
                buttonMdl2: ButtonModel? = null,
                buttonMdl3: ButtonModel? = null
        ): Dialog {
            when (type) {
                DialogType.NONE_BUTTONS -> {
                    return setupForNoneButtonsType(
                            title = title,
                            desc = desc,
                            buttonMdl1 = buttonMdl1,
                            buttonMdl2 = buttonMdl2,
                            buttonMdl3 = buttonMdl3
                    )
                }
                DialogType.BUTTON -> {
                    return setupForButtonType(
                            title = title,
                            desc = desc,
                            buttonMdl = buttonMdl1,
                    )
                }
                DialogType.LOADING -> {
                    return setupForLoadingType(desc)
                }
            }
        }

        fun Dialog.setupForNoneButtonsType(
                title: Int = 0,
                desc: Int = 0,
                buttonMdl1: ButtonModel?,
                buttonMdl2: ButtonModel? = null,
                buttonMdl3: ButtonModel? = null
        ): Dialog {
            return this
        }

        fun Dialog.setupForButtonType(
                title: Int = 0,
                desc: Int = 0,
                buttonMdl: ButtonModel?
        ): Dialog {
            this.setContentView(R.layout.dialog_button)
            val titleTV = this.findViewById<TextView>(R.id.title)
            val descTV = this.findViewById<TextView>(R.id.desc)
            val btnBtn = this.findViewById<Button>(R.id.button)
            if (title != 0) {
                titleTV.text = context.getString(title)
            }
            if (desc != 0) {
                descTV.text = context.getString(desc)
            }
            buttonMdl?.let {
                btnBtn.visibility = View.VISIBLE
                btnBtn.text = context.getString(it.title)
                btnBtn.setOnClickListener { _ -> it.onClick() }
            }
            return this
        }

        fun Dialog.setupForLoadingType(
            desc: Int = 0
        ): Dialog {
            this.setContentView(R.layout.dialog_loading)
            val descTV = this.findViewById<TextView>(R.id.desc)
            if (desc != 0) {
                descTV.text = context.getString(desc)
            }
            return this
        }

    }

}
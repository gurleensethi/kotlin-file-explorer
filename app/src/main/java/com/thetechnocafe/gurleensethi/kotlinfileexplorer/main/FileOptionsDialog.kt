package com.thetechnocafe.gurleensethi.kotlinfileexplorer.main

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thetechnocafe.gurleensethi.kotlinfileexplorer.R

class FileOptionsDialog() : BottomSheetDialogFragment() {

    companion object {
        fun build(block: Builder.() -> Unit): FileOptionsDialog = Builder().apply(block).build()
    }

    class Builder {
        var path: String? = null

        fun build(): FileOptionsDialog {
            val fragment = FileOptionsDialog()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_file_options, container, false)
    }
}
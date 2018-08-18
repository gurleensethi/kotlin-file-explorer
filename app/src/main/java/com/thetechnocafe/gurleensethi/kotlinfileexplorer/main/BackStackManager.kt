package com.thetechnocafe.gurleensethi.kotlinfileexplorer.main

import com.thetechnocafe.gurleensethi.kotlinfileexplorer.models.FileModel

class BackStackManager {
    private var files = mutableListOf<FileModel>()
    var onStackChangeListener: ((List<FileModel>) -> Unit)? = null

    val top: FileModel
        get() = files[files.size - 1]

    fun addToStack(fileModel: FileModel) {
        files.add(fileModel)
        onStackChangeListener?.invoke(files)
    }

    fun popFromStack() {
        if (files.isNotEmpty())
            files.removeAt(files.size - 1)
        onStackChangeListener?.invoke(files)
    }

    fun popFromStackTill(fileModel: FileModel) {
        files = files.subList(0, files.indexOf(fileModel) + 1)
        onStackChangeListener?.invoke(files)
    }
}
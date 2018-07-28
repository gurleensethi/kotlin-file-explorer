package com.thetechnocafe.gurleensethi.kotlinfileexplorer.models

import com.thetechnocafe.gurleensethi.kotlinfileexplorer.common.FileType
import java.io.File

data class FileModel(
        val path: String,
        val fileType: FileType,
        val name: String,
        val sizeInMB: Double,
        val extension: String = "",
        val subFiles: Int = 0
)
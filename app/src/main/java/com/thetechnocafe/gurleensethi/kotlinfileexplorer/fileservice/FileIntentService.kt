package com.thetechnocafe.gurleensethi.kotlinfileexplorer.fileservice

import android.app.IntentService
import android.content.Intent
import android.widget.Toast
import java.io.File

class FileIntentService : IntentService("FileIntentService") {

    companion object {
        const val ACTION_COPY: String = "com.thetechnocafe.gurleensethi.kotlinfileexplorer.fileservice.copy"

        const val EXTRA_FILE_SOURCE_PATH: String = "com.thetechnocafe.gurleensethi.kotlinfileexplorer.fileservice.source_path"
        const val EXTRA_FILE_DESTINATION_PATH: String = "com.thetechnocafe.gurleensethi.kotlinfileexplorer.fileservice.destination_path"
    }

    override fun onHandleIntent(intent: Intent?) {
        if (intent?.action == ACTION_COPY) {
            if (intent.hasExtra(EXTRA_FILE_SOURCE_PATH) && intent.hasExtra(EXTRA_FILE_DESTINATION_PATH)) {
                copyFile(
                        intent.getStringExtra(EXTRA_FILE_SOURCE_PATH),
                        intent.getStringExtra(EXTRA_FILE_DESTINATION_PATH)
                )
            }
        }
    }

    private fun copyFile(source: String, destination: String) {
        val sourceFile = File(source)
        val destinationFile = File(destination + "/${sourceFile.nameWithoutExtension}-copy${sourceFile.extension}")

        if (!destinationFile.exists()) {
            destinationFile.createNewFile()
        }

        sourceFile.copyTo(destinationFile)

        Toast.makeText(applicationContext, "File Copied!", Toast.LENGTH_SHORT).show()
    }
}
package com.javavirys.minecraftmod.util

import android.content.Context
import android.util.Log
import java.io.*

object FileUtils {

    fun copyFileFromAssets(context: Context, filePath: String, toDir: String) {
        val filename = filePath.substringAfterLast("/")
        try {
            val inputStream = context.assets.open(filePath)
            File(toDir).mkdirs()
            val outFile = File(toDir, filename)
            outFile.createNewFile()
            val outputStream = FileOutputStream(outFile)
            copyFile(inputStream, outputStream)
            inputStream.close()
            outputStream.flush()
            outputStream.close()
        } catch (e: IOException) {
            Log.e("tag", "Failed to copy asset file: $filename", e)
        }
    }

    private fun copyFile(inputStream: InputStream, outputStream: OutputStream) {
        val buffer = ByteArray(1024)
        var read: Int
        while (inputStream.read(buffer).also { read = it } != -1) {
            outputStream.write(buffer, 0, read)
        }
    }
}
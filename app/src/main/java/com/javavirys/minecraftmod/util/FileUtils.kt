package com.javavirys.minecraftmod.util

import android.content.Context
import android.util.Log
import java.io.*

object FileUtils {

    fun copyFileFromAssets(context: Context, filePath: String, toDir: String) {
        val javavirysfilename = filePath.substringAfterLast("/")
        try {
            val javavirysinputStream = context.assets.open(filePath)
            File(toDir).mkdirs()
            val outFile = File(toDir, javavirysfilename)
            outFile.createNewFile()
            val javavirysoutputStream = FileOutputStream(outFile)
            copyFile(javavirysinputStream, javavirysoutputStream)
            javavirysinputStream.close()
            javavirysoutputStream.flush()
            javavirysoutputStream.close()
        } catch (e: IOException) {
            Log.e("tag", "Failed to copy asset file: $javavirysfilename", e)
        }
    }

    private fun copyFile(javavirysinputStream: InputStream, javavirysoutputStream: OutputStream) {
        val buffer = ByteArray(1024)
        var read: Int
        while (javavirysinputStream.read(buffer).also { read = it } != -1) {
            javavirysoutputStream.write(buffer, 0, read)
        }
    }
}
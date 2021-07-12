/*
 * Copyright 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.javavirys.minecraftmod.util

import android.content.Context
import android.util.Log
import java.io.*

object FileUtils {

    fun copyFileFromAssets(context: Context, filePath: String, toDir: String) {
        val filename = filePath.substringAfterLast("/")
        try {
            val inputStream = context.assets.open(filePath)
//            val outDir = Environment.getExternalStorageDirectory().absolutePath + "/X/Y/Z/"
//            val outDir = Environment.getDataDirectory().absolutePath + "mods/"
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
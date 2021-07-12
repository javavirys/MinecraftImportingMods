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

package com.javavirys.minecraftmod.data.repository

import android.content.Context
import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import android.os.Environment
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.domain.repository.ImportModRepository
import com.javavirys.minecraftmod.util.FileUtils
import java.io.File


class FileSystemImportModRepository(
    private val context: Context
) : ImportModRepository {

    override suspend fun importMod(item: Mod) {
        val filePath =
            DIRECTORY_MODS + item.addonName
        FileUtils.copyFileFromAssets(
            context,
            "files/${item.addonName}",
            DIRECTORY_MODS
        )
        val intent = Intent(ACTION_VIEW)
        intent.flags = FLAG_GRANT_READ_URI_PERMISSION or FLAG_ACTIVITY_NEW_TASK
        intent.data = Uri.parse("minecraft://?import=$filePath")
        context.startActivity(intent)
    }

    override suspend fun isImportedMod(item: Mod): Boolean {
        val filePath =
            DIRECTORY_MODS + item.addonName
        return File(filePath).exists()
    }

    companion object {
        private val DIRECTORY_MODS =
            Environment.getExternalStorageDirectory().absolutePath + "/mods/"
    }
}
package com.javavirys.minecraftmod.di

import com.javavirys.minecraftmod.data.repository.AssetModRepository
import com.javavirys.minecraftmod.data.repository.DatabaseModRepository
import com.javavirys.minecraftmod.data.repository.FileSystemImportModRepository
import com.javavirys.minecraftmod.domain.repository.ImportModRepository
import com.javavirys.minecraftmod.domain.repository.ModRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ASSET_QUALIFIER = "asset"

const val DATABASE_QUALIFIER = "local"

val repositoryModule = module {

    single<ModRepository>(named(ASSET_QUALIFIER)) { AssetModRepository(get()) }

    single<ModRepository>(named(DATABASE_QUALIFIER)) { DatabaseModRepository(get(), get()) }

    single<ImportModRepository> { FileSystemImportModRepository(get()) }
}
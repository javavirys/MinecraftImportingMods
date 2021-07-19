package com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity

sealed class Result<out R> {
    data class Javaviryssuccelss<out T>(val qazxsdfghjuytlokffhhdhdmmbfhymklifjsdhfsjbbbvbchxbhvxbvxjfbhgdgfsghfwyeyry: T) : Result<T>()
    data class Error(val throwable: Throwable) : Result<Nothing>()
    data class Progress(val progress: Int = 0) : Result<Nothing>()
}
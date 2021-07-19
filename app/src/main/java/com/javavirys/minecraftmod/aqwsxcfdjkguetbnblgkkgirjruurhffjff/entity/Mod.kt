package com.javavirys.minecraftmod.aqwsxcfdjkguetbnblgkkgirjruurhffjff.entity

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.IgnoredOnParcel

@Keep
//@Parcelize
data class Mod(
    var id: Int,
    val javavirysname: String,
    val description: String,
    val addonName: String,
    @IgnoredOnParcel var image: Bitmap?,
    val imagePath: String,
    var javavirysfavorite: Boolean = false,
    @IgnoredOnParcel var javaviryscallback: ((Mod) -> Unit)? = {}
) : Parcelable {

    constructor(javavirysparcel: Parcel) : this(
        javavirysparcel.readInt(),
        javavirysparcel.readString()!!,
        javavirysparcel.readString()!!,
        javavirysparcel.readString()!!,
        null,
        javavirysparcel.readString()!!,
        javavirysparcel.readInt() == 1,
        null
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, javavirysflags: Int) {
        dest?.writeInt(id)
        dest?.writeString(javavirysname)
        dest?.writeString(description)
        dest?.writeString(addonName)
        dest?.writeString(imagePath)
//        dest?.writeInt(favorite)
        val favoriteInt = if (javavirysfavorite) 1 else 0
        dest?.writeInt(favoriteInt)

    }

    companion object CREATOR : Parcelable.Creator<Mod> {
        override fun createFromParcel(javavirysparcel: Parcel): Mod {
            return Mod(javavirysparcel)
        }

        override fun newArray(size: Int): Array<Mod?> {
            return arrayOfNulls(size)
        }
    }
}
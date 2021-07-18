package com.javavirys.minecraftmod.core.entity

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.IgnoredOnParcel

@Keep
//@Parcelize
data class Mod(
    var id: Int,
    val name: String,
    val description: String,
    val addonName: String,
    @IgnoredOnParcel val image: Bitmap?,
    val imagePath: String,
    var favorite: Boolean = false,
    @IgnoredOnParcel var callback: ((Mod) -> Unit)? = {}
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        null,
        parcel.readString()!!,
        parcel.readInt() == 1,
        null
    )

    override fun describeContents(): Int {
        return 0
    }

    //
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(id)
        dest?.writeString(name)
        dest?.writeString(description)
        dest?.writeString(addonName)
        dest?.writeString(imagePath)
//        dest?.writeInt(favorite)
        val favoriteInt = if (favorite) 1 else 0
        dest?.writeInt(favoriteInt)

    }

    companion object CREATOR : Parcelable.Creator<Mod> {
        override fun createFromParcel(parcel: Parcel): Mod {
            return Mod(parcel)
        }

        override fun newArray(size: Int): Array<Mod?> {
            return arrayOfNulls(size)
        }
    }
}
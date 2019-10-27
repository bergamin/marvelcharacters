package com.bergamin.marvelcharacters.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.common.truth.Truth

object ParcelableTester {
    fun <T : Parcelable> assertParcelable(parcelableObject: T, creator: Parcelable.Creator<T>) {
        val parcel = Parcel.obtain()
        parcelableObject.writeToParcel(parcel, parcelableObject.describeContents())
        parcel.setDataPosition(0)

        val parceledObject = creator.createFromParcel(parcel)

        Truth.assertThat(parcelableObject).isEqualTo(parceledObject)
    }
}

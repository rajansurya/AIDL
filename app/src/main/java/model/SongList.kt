package model

import android.os.Parcelable
import androidx.room.Entity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Parcelize
data class SongList constructor(@JsonProperty("resultCount")val resultCount:Int, @JsonProperty("results")var results :MutableList<SongResult>):
    Parcelable
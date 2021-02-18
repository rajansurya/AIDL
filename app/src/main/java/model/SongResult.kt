package model

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(tableName = "word_table")
@Parcelize
data class  SongResult constructor(@JsonProperty("artistId")var artistId:Int,@JsonProperty("trackName") var trackName:String,@JsonProperty("trackTimeMillis") var trackTimeMillis:Int,@JsonProperty("artworkUrl100") var artworkUrl100:String, @PrimaryKey @JsonProperty("trackId") var trackId:Long,@JsonProperty("artistName")var artistName :String ,@JsonProperty("collectionName")var collectionName:String,@JsonProperty("releaseDate")var releaseDate:String):Parcelable

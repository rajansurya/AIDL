package repository.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import model.SongResult

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: SongResult): Long

    @Query("SELECT * from word_table")
    fun queryData(): LiveData<MutableList<SongResult>>
}
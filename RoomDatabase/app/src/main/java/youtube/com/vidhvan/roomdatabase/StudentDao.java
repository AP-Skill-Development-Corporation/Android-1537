package youtube.com.vidhvan.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao
{
    @Insert
    void insert(StudentEntity studentEntity);

    @Query("select * from student")
    List<StudentEntity> getData();
}

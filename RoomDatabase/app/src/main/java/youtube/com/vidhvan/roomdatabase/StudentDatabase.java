package youtube.com.vidhvan.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StudentEntity.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase
{
    public abstract StudentDao studentDao();
}

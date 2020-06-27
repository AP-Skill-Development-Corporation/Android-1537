package youtube.com.vidhvan.roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    int id;

    String name;

    int age;

    public StudentEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

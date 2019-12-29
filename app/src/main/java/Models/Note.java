package Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "My_notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="Title")
    @NonNull
    private String title;

    @ColumnInfo(name="Description")
    @NonNull
    private String description;

    public Note(@NonNull String title, @NonNull String description) {
        this.title = title;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}

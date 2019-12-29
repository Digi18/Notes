package Repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Dao.NoteDao;
import Models.Note;

@Database(entities = {Note.class},version = 1)
public abstract class DatabaseSingleton extends RoomDatabase {

    private static DatabaseSingleton instance;

    public abstract NoteDao noteDao();

    public static synchronized DatabaseSingleton getInstance(Context context){

        if(instance == null){

            instance = Room.databaseBuilder(context.getApplicationContext(),DatabaseSingleton.class,
                    "Note_database").fallbackToDestructiveMigration().build();
        }

        return instance;
    }
}

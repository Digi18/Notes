package Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Models.Note;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Query("SELECT * FROM My_notes ORDER BY id DESC")
    LiveData<List<Note>> getAllNotes();

}

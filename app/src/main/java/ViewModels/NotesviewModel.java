package ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Models.Note;
import Repository.NoteRepository;

public class NotesviewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    public NotesviewModel(@NonNull Application application) {
        super(application);

        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }

    public void insert(Note note){

        noteRepository.insert(note);
    }

    public LiveData<List<Note>> getAllNotes(){

        return allNotes;
    }


}

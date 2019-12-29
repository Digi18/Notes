package Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import Dao.NoteDao;
import Models.Note;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    private DatabaseSingleton db;

    public NoteRepository(Application application){

        db = DatabaseSingleton.getInstance(application);
        noteDao = db.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note){

        new InsertNoteAsyncTask(noteDao).execute(note);

    }

    public LiveData<List<Note>> getAllNotes(){

        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{

        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao) {

            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.insert(notes[0]);
            return null;
        }
    }
}

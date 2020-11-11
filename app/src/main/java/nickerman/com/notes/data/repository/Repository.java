package nickerman.com.notes.data.repository;

import java.util.List;

import io.reactivex.Flowable;
import nickerman.com.notes.models.Note;

public class Repository implements INotesDataSource {

    private INotesDataSource iNotesDataSource;
    private static Repository INSTANCE;

    public static Repository getInstance(INotesDataSource iNotesDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(iNotesDataSource);
        }
        return INSTANCE;
    }

    private Repository(INotesDataSource iNotesDataSource) {
        this.iNotesDataSource = iNotesDataSource;
    }


    @Override
    public Flowable<List<Note>> getAllNotes() {
        return iNotesDataSource.getAllNotes();
    }

    @Override
    public void setNotes(List<Note> notes) {
        iNotesDataSource.setNotes(notes);
    }

    @Override
    public void setNote(Note note) {
        iNotesDataSource.setNote(note);
    }

    @Override
    public void deleteNote(Note note) {
        iNotesDataSource.deleteNote(note);
    }

    @Override
    public Flowable<Note> getNoteById(int id) {
        return iNotesDataSource.getNoteById(id);
    }
}

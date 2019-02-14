package nickerman.com.notes.data;

import java.util.List;

import io.reactivex.Flowable;
import nickerman.com.notes.data.dao.NotesDAO;
import nickerman.com.notes.data.repository.INotesDataSource;
import nickerman.com.notes.models.Note;

public class NoteDataSource implements INotesDataSource {

    private NotesDAO notesDAO;
    private static NoteDataSource INSTANCE;

    public NoteDataSource(NotesDAO notesDAO) {
        this.notesDAO = notesDAO;
    }

    public static NoteDataSource getInstance(NotesDAO notesDAO) {
        if (INSTANCE == null) {
            INSTANCE = new NoteDataSource(notesDAO);
        }
        return INSTANCE;
    }

    @Override
    public Flowable<List<Note>> getAllNotes() {
        return this.notesDAO.getAllNotes();
    }

    @Override
    public Flowable<Note> getNoteById(int id) {
        return this.notesDAO.getNoteById(id);
    }

    @Override
    public void setNotes(List<Note> notes) {
        this.notesDAO.setNotes(notes);
    }

    @Override
    public void setNote(Note note) {
        this.notesDAO.setNote(note);
    }

    @Override
    public void deleteNote(Note note) {
        this.notesDAO.deleteNote(note);
    }
}

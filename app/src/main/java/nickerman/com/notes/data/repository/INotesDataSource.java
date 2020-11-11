package nickerman.com.notes.data.repository;

import java.util.List;

import io.reactivex.Flowable;
import nickerman.com.notes.models.Note;

public interface INotesDataSource {
    //get all notes from db
    Flowable<List<Note>> getAllNotes();

    Flowable<Note> getNoteById(int id);

    //set list notes in db
    void setNotes(List<Note> notes);

    //set note into db
    void setNote(Note note);

    //delete note in db
    void deleteNote(Note note);

}

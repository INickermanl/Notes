package nickerman.com.notes.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import nickerman.com.notes.models.Note;

@Dao
public interface NotesDAO {

    //get all notes from db
    @Query("SELECT * FROM note")
    Flowable<List<Note>> getAllNotes();

    @Query("SELECT * FROM note WHERE id= :id")
    Flowable<Note> getNoteById(int id);

    //set list notes in db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setNotes(List<Note> notes);

    //set note into db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setNote(Note note);

    //delete note in db
    @Delete
    void deleteNote(Note note);
}

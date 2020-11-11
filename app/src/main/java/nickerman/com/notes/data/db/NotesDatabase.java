package nickerman.com.notes.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import nickerman.com.notes.base.App;
import nickerman.com.notes.data.dao.NotesDAO;
import nickerman.com.notes.models.Note;

@Database(entities = {Note.class}, exportSchema = false, version = 1)
public abstract class NotesDatabase extends RoomDatabase {


    public abstract NotesDAO notesDAO();

    private static NotesDatabase INSTANCE;

    public static NotesDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = INSTANCE = Room.databaseBuilder(
                    App.getInstance(),
                    NotesDatabase.class,
                    "notes.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }


}

package nickerman.com.notes.screens.main;

import java.util.List;

import nickerman.com.notes.adapters.INoteClick;
import nickerman.com.notes.models.Note;
import nickerman.com.notes.util.navigation.Navigator;

public interface NotesContract {
    interface View{
        void setAdapter(List<Note> notes, INoteClick iNoteClick);

    }
    interface Presenter{
        void setNavigator(Navigator navigator);
        void start(View view);
        void stop();

    }
}

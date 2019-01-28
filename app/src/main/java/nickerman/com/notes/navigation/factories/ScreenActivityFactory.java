package nickerman.com.notes.navigation.factories;

import android.app.Activity;
import android.content.Intent;

import nickerman.com.notes.EditActivity;
import nickerman.com.notes.NotesActivity;
import nickerman.com.notes.base.App;
import nickerman.com.notes.navigation.Screen;


public class ScreenActivityFactory {

    public Intent getActivityByType(Screen screen) {
        return new Intent(App.getInstance(), getActivityClassByType(screen));
    }

    private Class<? extends Activity> getActivityClassByType(Screen screen) {
        switch (screen) {
            case NOTES:
                return NotesActivity.class;
            case EDIT:
                return EditActivity.class;


            default:
                return NotesActivity.class;
        }
    }

}

package nickerman.com.notes.screens.main;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import nickerman.com.notes.adapters.INoteClick;
import nickerman.com.notes.base.Constants;
import nickerman.com.notes.models.Note;
import nickerman.com.notes.util.navigation.Navigator;
import nickerman.com.notes.util.navigation.Screen;
import nickerman.com.notes.util.navigation.ScreenType;

public class NotesPresenter implements NotesContract.Presenter, INoteClick {


    private NotesContract.View view;
    private List<Note> mNotes = new ArrayList<>();
    private Navigator navigator;

    public NotesPresenter() {
        setNotes();
    }

    @Override
    public void start(NotesContract.View view) {
        this.view = view;
        initView();
    }

    @Override
    public void stop() {

    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void onNoteClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EDIT_POSITION, position);
        navigator.navigateTo(Screen.EDIT,ScreenType.ACTIVITY);
    }


    private void initView() {
        view.setAdapter(mNotes, this);
    }

    private void setNotes() {
        for (int i = 1; i < 32; i++) {
            Note note = new Note("title" + i, "subtitle" + i, "Jun" + i);

            mNotes.add(note);
        }
    }
}

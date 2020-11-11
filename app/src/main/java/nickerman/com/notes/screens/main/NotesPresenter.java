package nickerman.com.notes.screens.main;

import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import nickerman.com.notes.adapters.INoteClick;
import nickerman.com.notes.base.Constants;
import nickerman.com.notes.data.NoteDataSource;
import nickerman.com.notes.data.db.NotesDatabase;
import nickerman.com.notes.data.repository.Repository;
import nickerman.com.notes.models.Note;
import nickerman.com.notes.util.navigation.Navigator;
import nickerman.com.notes.util.navigation.Screen;
import nickerman.com.notes.util.navigation.ScreenType;

public class NotesPresenter implements NotesContract.Presenter, INoteClick{


    private NotesContract.View view;
    private List<Note> mNotes = new ArrayList<>();
    private Navigator navigator;
    private Repository mRepository;
    private CompositeDisposable subscription;
    private static final String TAG = "NotesPresenter";

    public NotesPresenter() {

        this.mRepository = Repository.getInstance(NoteDataSource.getInstance(NotesDatabase.getInstance().notesDAO()));
    }

    @Override
    public void start(NotesContract.View view) {
        subscription = new CompositeDisposable();
        this.view = view;
        initView();

        initAction();


    }

    private void initAction() {

        view.fabAction().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                subscription.add(d);
            }

            @Override
            public void onNext(Object o) {
                navigator.navigateTo(Screen.EDIT, ScreenType.ACTIVITY);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Disposable disposable = this.mRepository.getAllNotes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<List<Note>>() {
                    @Override
                    public void accept(List<Note> notes) throws Exception {
                        onGetAllWordSuccess(notes);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: " + throwable.getLocalizedMessage());
                    }
                });

        subscription.add(disposable);
    }

    private void onGetAllWordSuccess(List<Note> notes) {
        mNotes.clear();
        mNotes.addAll(notes);
        view.setNotes(mNotes);
    }


    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void onNoteClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.EDIT_POSITION, position);
        navigator.navigateTo(Screen.EDIT, ScreenType.ACTIVITY, bundle);
    }


    private void initView() {
        view.setAdapter(this);
        /*createNotes();*/

    }

    @Override
    public void stop() {
        subscription.dispose();
    }
/*
    private void createNotes() {
        for (int i = 1; i < 15; i++) {
            Note note = new Note("title" + i, "subtitle" + i, "Jun" + i);

            mNotes.add(note);
        }

        view.setNotes(mNotes);
    }*/
}

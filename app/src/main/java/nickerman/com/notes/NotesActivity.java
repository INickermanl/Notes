package nickerman.com.notes;

import android.os.Bundle;
import android.view.View;

import nickerman.com.notes.base.BaseActivity;
import nickerman.com.notes.screens.main.NotesContract;
import nickerman.com.notes.screens.main.NotesPresenter;
import nickerman.com.notes.screens.main.NotesView;

public class NotesActivity extends BaseActivity {

    private View root;
    private NotesContract.View view;
    private NotesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.root = findViewById(R.id.root);
        view = new NotesView(root);
        presenter = new NotesPresenter();

        
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setNavigator(getNavigator());
        presenter.start(view);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }
}

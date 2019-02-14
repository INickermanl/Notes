package nickerman.com.notes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import nickerman.com.notes.base.BaseActivity;
import nickerman.com.notes.base.Constants;
import nickerman.com.notes.screens.edit.EditContract;
import nickerman.com.notes.screens.edit.EditPresenter;
import nickerman.com.notes.screens.edit.EditView;

public class EditActivity extends BaseActivity {
    private View root;
    private EditContract.View view;
    private EditContract.Presenter presenter;

    private static final String TAG = "EditActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        this.root = findViewById(R.id.root);


        int i = getIntent().getIntExtra(Constants.EDIT_POSITION, -1);
        view = new EditView(root);
        presenter = new EditPresenter(i);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start(view);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

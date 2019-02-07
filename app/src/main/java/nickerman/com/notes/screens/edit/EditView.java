package nickerman.com.notes.screens.edit;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;
import nickerman.com.notes.R;
import nickerman.com.notes.util.ui.LineEditText;

public class EditView implements EditContract.View {

    private View root;

    private TextView summaryT;
    private ImageView acceptEdit, back;
    private EditText summaryEt;
    private LineEditText contentEt;
    private View contentMain, contentEditMode;

    public EditView(View root) {
        this.root = root;
        intiView();
    }

    private void intiView() {
        summaryT = root.findViewById(R.id.summary_t);
        summaryEt = root.findViewById(R.id.summary_et);
        acceptEdit = root.findViewById(R.id.accept_edit);
        contentEt = root.findViewById(R.id.content_et);
        back = root.findViewById(R.id.back);
        contentMain = root.findViewById(R.id.content_main);
        contentEditMode = root.findViewById(R.id.content_edit);

    }

    @Override
    public Observable<Object> acceptEditButtonAction() {
        return RxView.clicks(acceptEdit);
    }

    @Override
    public Observable<Object> backButtonAction() {
        return RxView.clicks(back);
    }

    @Override
    public void editMode(boolean onMode) {
        if(onMode) {
            contentMain.setVisibility(View.GONE);
            setSummaryEditText(getSummaryText());
            contentEditMode.setVisibility(View.VISIBLE);
        }else{
            contentEditMode.setVisibility(View.GONE);
            setSummaryText(getSummaryEditText());
            contentMain.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void setContentText(String contentText) {
        contentEt.setText(contentText);
    }

    @Override
    public String getContentText() {
        return contentEt.getText().toString();
    }

    @Override
    public void setSummaryText(String summaryText) {
        summaryT.setText(summaryText);
    }

    @Override
    public String getSummaryText() {
        return summaryT.getText().toString();
    }

    @Override
    public void setSummaryEditText(String summaryText) {
    summaryEt.setText(summaryText);
    }

    @Override
    public String getSummaryEditText() {
        return summaryEt.getText().toString();
    }
}

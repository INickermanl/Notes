package nickerman.com.notes.screens.edit;

import io.reactivex.Observable;

public interface EditContract {
    interface View {

        Observable<Object> acceptEditButtonAction();
        Observable<Object> backButtonAction();

        void editMode(boolean onMode);

        void setContentText(String contentText);
        String getContentText();

        void setSummaryText(String summaryText);
        String getSummaryText();

        void setSummaryEditText(String summaryText);
        String getSummaryEditText();

    }

    interface Presenter {
        void start(View view);
        void stop();
    }
}

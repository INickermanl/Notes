package nickerman.com.notes.screens.edit;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class EditPresenter implements EditContract.Presenter {

    private EditContract.View view;
    private CompositeDisposable subscription;

    public EditPresenter() {
        subscription = new CompositeDisposable();
    }

    @Override
    public void start(EditContract.View view) {
        this.view = view;
        initAction();
    }

    private void initAction() {

        view.acceptEditButtonAction().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                subscription.add(d);
            }

            @Override
            public void onNext(Object o) {
                view.editMode(false);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void stop() {
        subscription.dispose();
        subscription = null;
    }
}

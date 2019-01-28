package nickerman.com.notes.util.navigation.managers;

import android.content.Intent;
import android.os.Bundle;

import nickerman.com.notes.base.BaseActivity;
import nickerman.com.notes.util.navigation.Navigator;
import nickerman.com.notes.util.navigation.Screen;
import nickerman.com.notes.util.navigation.ScreenAnimType;
import nickerman.com.notes.util.navigation.ScreenType;
import nickerman.com.notes.util.navigation.factories.ScreenActivityFactory;
import nickerman.com.notes.util.navigation.factories.ScreenFragmentFactory;


public class ScreenNavigationManager implements Navigator {

    public final static String ACTIVITY_REQUEST_CODE = "ScreenNavigationManager.activityRequestCode";

    public final ScreenActivityFactory activityFactory;
    public final ScreenFragmentFactory fragmentFactory;
    public BaseActivity activity;
    private Screen screen;

    public BaseActivity getActivity() {
        return activity;
    }


    @Override
    public Screen getScreen() {
        return this.screen;
    }


    public ScreenNavigationManager(BaseActivity activity) {
        this.activity = activity;
        activityFactory = new ScreenActivityFactory();
        fragmentFactory = new ScreenFragmentFactory();
    }

    @Override
    public void navigateTo(Screen screen, ScreenType type) {
        navigateTo(screen, type, null);
    }

    @Override
    public void navigateTo(Screen screen, ScreenType type, Bundle args) {
        switch (type) {
            case ACTIVITY:
                navigateToActivity(screen, args);
                this.screen = screen;
                break;
            case FRAGMENT:
                navigateToFragment(screen, args);
                this.screen = screen;
                break;
        }
    }

    private void navigateToActivity(Screen screen, Bundle args) {
        switch (screen) {
            case NOTES:
                navigateToNotes(args);
                break;
            case EDIT:
                navigateToEdit(args);
                break;
        }
    }




    private void navigateToFragment(Screen screen, Bundle args) {
        switch (screen) {


        }
    }


    //Activity
    private void navigateToNotes(Bundle args) {
        switchActivityScreen(Screen.NOTES,args,ScreenAnimType.NONE_TYPE,true);
        activity.hideKeyboard();
    }
    private void navigateToEdit(Bundle args) {
        switchActivityScreen(Screen.EDIT,args,ScreenAnimType.NONE_TYPE,false);
        activity.hideKeyboard();
    }


    private void switchActivityScreen(Screen type, Bundle bundle, ScreenAnimType animate, boolean clearStack) {
        Intent intent = activityFactory.getActivityByType(type);
        if (clearStack) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }

        if (bundle != null && !bundle.isEmpty()) {
            intent.putExtras(bundle);
        }

        // logic for enabling handling result in onActivityResult
        int requestCode = 0;
        if (bundle != null) {
            requestCode = bundle.getInt(ACTIVITY_REQUEST_CODE, 0);
        }
        if (requestCode != 0) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }


    }
}



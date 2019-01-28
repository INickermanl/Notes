package nickerman.com.notes.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import nickerman.com.notes.util.navigation.Navigator;
import nickerman.com.notes.util.navigation.managers.ScreenNavigationManager;
import timber.log.Timber;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private Handler handler;
    private Navigator navigator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, " onCreate()" + (savedInstanceState != null ? " recreating" : ""));
        super.onCreate(savedInstanceState);
        handler = new Handler(Looper.getMainLooper());

        navigator = new ScreenNavigationManager(this);
        /*
        navigationBackManager = new ScreenNavigationBackManager(this);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, " onStart()");
    }


    @Override
    protected void onStop() {
        Log.i(TAG, " onStop()");
        super.onStop();
    }

    @Override
    public void onBackPressed() {
    super.onBackPressed();
    }


    @Override
    protected void onResume() {
        Log.i(TAG, " onResume()");
        super.onResume();
        //checkConnectivity();
    }

    @Override
    protected void onPostResume() {
        Log.i(TAG, " onPostResume()");
        super.onPostResume();
    }


    @Override
    protected void onPause() {
        Log.i(TAG, " onPause()");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, " onDestroy()");
        super.onDestroy();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent() Intent=" + intent);
    }

    public void freeMemory() {
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }
    public void hideKeyboard() {
        try {
            IBinder windowToken = getWindow().getDecorView().getRootView().getWindowToken();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(windowToken, 0);
        } catch (Exception e) {
            Timber.e(e.getLocalizedMessage());
        }
    }
     public Navigator getNavigator(){
        return this.navigator;
    }

}

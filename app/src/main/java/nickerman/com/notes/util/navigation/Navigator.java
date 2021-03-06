package nickerman.com.notes.util.navigation;

import android.os.Bundle;


public interface Navigator {
    void navigateTo(Screen screen, ScreenType type);
    void navigateTo(Screen screen, ScreenType type, Bundle args);
    Screen getScreen();
}

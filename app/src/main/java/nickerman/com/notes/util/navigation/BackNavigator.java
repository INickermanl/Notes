package nickerman.com.notes.util.navigation;

public interface BackNavigator {
    void navigateBack();
    void tryExitActivity();
    void setCouldNavigateBack(boolean couldNavigateBack);
}

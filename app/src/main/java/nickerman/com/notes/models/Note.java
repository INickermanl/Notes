package nickerman.com.notes.models;

public class Note {
   private String title;
   private String subtitle;
   private String timesTamp;

    public Note(String title, String subtitle, String timesTamp) {
        this.title = title;
        this.subtitle = subtitle;
        this.timesTamp = timesTamp;
    }

    public Note() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(String timesTamp) {
        this.timesTamp = timesTamp;
    }
}


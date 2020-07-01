package hu.codecool.player.menu;

import hu.codecool.player.activity.Activity;

public class MenuItem {

    private String title;
    private Activity activity;

    public MenuItem(String title, Activity activity) {
        this.title = title;
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}

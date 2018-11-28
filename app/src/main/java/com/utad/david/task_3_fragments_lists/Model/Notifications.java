package com.utad.david.task_3_fragments_lists.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Notifications {
    private String date;
    private String userName;
    private String title;

    public Notifications(String date, String userName, String title) {
        this.date = date;
        this.userName = userName;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

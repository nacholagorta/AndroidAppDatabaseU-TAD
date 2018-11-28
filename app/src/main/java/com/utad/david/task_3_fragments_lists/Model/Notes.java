package com.utad.david.task_3_fragments_lists.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes{

    private String date;
    private String classes;
    private String works;
    private String notes;

    public Notes(String date, String classes, String works, String notes) {
        this.date = date;
        this.classes = classes;
        this.works = works;
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

package com.utad.david.task_3_fragments_lists.Model;


import android.os.Parcel;
import android.os.Parcelable;
//Implementa parcelable para poder pasarle el objeto al Dialog
public class Teacher implements Parcelable {

    private String nameteacher;
    private String surnameteacher;
    private int phototeacher;
    private String [] subject;
    private String description;
    private String emailteacher;

    public Teacher(String nameteacher, String surnameteacher, int phototeacher, String[] subject,String description,String emailteacher) {
        this.nameteacher = nameteacher;
        this.surnameteacher = surnameteacher;
        this.phototeacher = phototeacher;
        this.subject = subject;
        this.description = description;
        this.emailteacher = emailteacher;
    }


    protected Teacher(Parcel in) {
        nameteacher = in.readString();
        surnameteacher = in.readString();
        phototeacher = in.readInt();
        subject = in.createStringArray();
        description = in.readString();
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };

    public String getNameteacher() {
        return nameteacher;
    }

    public void setNameteacher(String nameteacher) {
        this.nameteacher = nameteacher;
    }

    public int getPhototeacher() {
        return phototeacher;
    }

    public void setPhototeacher(int phototeacher) {
        this.phototeacher = phototeacher;
    }

    public String getSurnameteacher() {
        return surnameteacher;
    }

    public void setSurnameteacher(String surnameteacher) {
        this.surnameteacher = surnameteacher;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailteacher() {
        return emailteacher;
    }

    public void setEmailteacher(String emailteacher) {
        this.emailteacher = emailteacher;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameteacher);
        dest.writeString(surnameteacher);
        dest.writeInt(phototeacher);
        dest.writeStringArray(subject);
        dest.writeString(description);
        dest.writeString(emailteacher);
    }
}
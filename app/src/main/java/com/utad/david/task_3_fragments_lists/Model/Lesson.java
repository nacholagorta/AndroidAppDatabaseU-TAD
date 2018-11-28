package com.utad.david.task_3_fragments_lists.Model;

import android.os.Parcel;
import android.os.Parcelable;
//Implementa parcelable para poder pasarle el objeto al Dialog
public class Lesson implements Parcelable {

    private String nameclass;
    private int photoclass;
    private String descripcion;
    private String courseYear;
    private String [] estadisticas;

    public Lesson(String nameclass, int photoclass, String courseYear, String descripcion, String [] estadisticas) {
        this.nameclass = nameclass;
        this.photoclass = photoclass;
        this.courseYear = courseYear;
        this.descripcion = descripcion;
        this.estadisticas = estadisticas;
    }

    public Lesson(Parcel in) {
        nameclass = in.readString();
        photoclass = in.readInt();
        courseYear = in.readString();
        descripcion = in.readString();
        estadisticas = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameclass);
        dest.writeInt(photoclass);
        dest.writeString(courseYear);
        dest.writeArray(estadisticas);
        dest.writeString(descripcion);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Lesson> CREATOR = new Creator<Lesson>() {
        @Override
        public Lesson createFromParcel(Parcel in) {
            return new Lesson(in);
        }

        @Override
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public int getPhotoclass() {
        return photoclass;
    }

    public void setPhotoclass(int photoclass) {
        this.photoclass = photoclass;
    }

    public String getCourseYear() { return courseYear; }

    public String getDescripcion() { return  descripcion; }

    public String[] getEstadisticas() { return estadisticas; }
}

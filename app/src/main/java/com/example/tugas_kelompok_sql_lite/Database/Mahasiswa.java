package com.example.tugas_kelompok_sql_lite.Database;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    String  number;
    String name,date,gender,location;

    public Mahasiswa() {

    }

    public String  getNumber() {
        return number;
    }

    public void setNumber(String  number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.number);
        dest.writeString(this.name);
        dest.writeString(this.date);
        dest.writeString(this.gender);
        dest.writeString(this.location);
    }

    protected Mahasiswa(Parcel in) {
        this.number = in.readString();
        this.name = in.readString();
        this.date = in.readString();
        this.gender = in.readString();
        this.location = in.readString();
    }
    public static final Parcelable.Creator<Mahasiswa> CREATOR=new Parcelable.Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

}

package com.android.dars.base.data;


import android.os.Parcel;
import android.os.Parcelable;

public class Addresses implements Parcelable {
    private String work;
    private String home;

    public Addresses(String work, String home) {
        this.work = work;
        this.home = home;
    }

    protected Addresses(Parcel in) {
        work = in.readString();
        home = in.readString();
    }

    public static final Creator<Addresses> CREATOR = new Creator<Addresses>() {
        @Override
        public Addresses createFromParcel(Parcel in) {
            return new Addresses(in);
        }

        @Override
        public Addresses[] newArray(int size) {
            return new Addresses[size];
        }
    };

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(work);
        dest.writeString(home);
    }
}

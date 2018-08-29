package com.android.dars.base.data;


import android.os.Parcel;
import android.os.Parcelable;

public class Phone  implements Parcelable {
    private String type;
    private String number;

    public Phone(String type, String number) {
        this.type = type;
        this.number = number;
    }

    protected Phone(Parcel in) {
        type = in.readString();
        number = in.readString();
    }

    public static final Creator<Phone> CREATOR = new Creator<Phone>() {
        @Override
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(number);
    }
}

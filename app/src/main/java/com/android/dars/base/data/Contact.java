package com.android.dars.base.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class Contact implements Parcelable{
    private String user_id;
    private String created_at;
    private String birth_date;
    private String first_name;
    private String last_name;
    private List<Phone> phones;
    private String thumb;
    private String photo;
    private List<Addresses> addresses;

    public Contact(String user_id, String created_at, String birth_date, String first_name,
                   String last_name, List<Phone> phones, String thumb, String photo,
                   List<Addresses> addresses) {
        this.user_id = user_id;
        this.created_at = created_at;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phones = phones;
        this.thumb = thumb;
        this.photo = photo;
        this.addresses = addresses;
    }

    public Contact(Parcel in) {
        user_id = in.readString();
        created_at = in.readString();
        birth_date = in.readString();
        first_name = in.readString();
        last_name = in.readString();
        thumb = in.readString();
        photo = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFirstLetter() {
        return first_name.isEmpty() ? "" : first_name.substring(0, 1);
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_id);
        dest.writeString(created_at);
        dest.writeString(birth_date);
        dest.writeString(first_name);
        dest.writeString(last_name);
        dest.writeString(thumb);
        dest.writeString(photo);
    }
}

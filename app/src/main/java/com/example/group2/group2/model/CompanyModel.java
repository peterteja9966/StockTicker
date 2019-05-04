package com.example.group2.group2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 5/4/2019.
 */

public class CompanyModel implements Parcelable {
    private String name;
    public static final Creator<CompanyModel> CREATOR = new Creator<CompanyModel>() {
        @Override
        public CompanyModel createFromParcel(Parcel in) {
            return new CompanyModel(in);
        }

        @Override
        public CompanyModel[] newArray(int size) {
            return new CompanyModel[size];
        }
    };
    private String value;

    public CompanyModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    protected CompanyModel(Parcel in) {
        name = in.readString();
        value = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(value);
    }
}

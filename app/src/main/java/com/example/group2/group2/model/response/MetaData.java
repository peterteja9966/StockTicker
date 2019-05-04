
package com.example.group2.group2.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaData implements Parcelable {

    public final static Creator<MetaData> CREATOR = new Creator<MetaData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MetaData createFromParcel(Parcel in) {
            return new MetaData(in);
        }

        public MetaData[] newArray(int size) {
            return (new MetaData[size]);
        }

    };
    @SerializedName("1. Information")
    @Expose
    private String _1Information;
    @SerializedName("2. Notes")
    @Expose
    private String _2Notes;
    @SerializedName("3. Time Zone")
    @Expose
    private String _3TimeZone;

    protected MetaData(Parcel in) {
        this._1Information = ((String) in.readValue((String.class.getClassLoader())));
        this._2Notes = ((String) in.readValue((String.class.getClassLoader())));
        this._3TimeZone = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MetaData() {
    }

    public String get1Information() {
        return _1Information;
    }

    public void set1Information(String _1Information) {
        this._1Information = _1Information;
    }

    public String get2Notes() {
        return _2Notes;
    }

    public void set2Notes(String _2Notes) {
        this._2Notes = _2Notes;
    }

    public String get3TimeZone() {
        return _3TimeZone;
    }

    public void set3TimeZone(String _3TimeZone) {
        this._3TimeZone = _3TimeZone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_1Information);
        dest.writeValue(_2Notes);
        dest.writeValue(_3TimeZone);
    }

    public int describeContents() {
        return 0;
    }

}

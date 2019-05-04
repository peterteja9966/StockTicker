package com.example.group2.group2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockDetails implements Parcelable {

    @SerializedName("Global Quote")
    @Expose
    public StockDetailResponse globalQuote;

    public StockDetailResponse getGlobalQuote() {
        return globalQuote;
    }

    public void setGlobalQuote(StockDetailResponse globalQuote) {
        this.globalQuote = globalQuote;
    }

    protected StockDetails(Parcel in) {
        globalQuote = in.readParcelable(StockDetailResponse.class.getClassLoader());
    }

    public static final Creator<StockDetails> CREATOR = new Creator<StockDetails>() {
        @Override
        public StockDetails createFromParcel(Parcel in) {
            return new StockDetails(in);
        }

        @Override
        public StockDetails[] newArray(int size) {
            return new StockDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(globalQuote, i);
    }
}

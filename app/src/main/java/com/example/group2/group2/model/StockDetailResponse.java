package com.example.group2.group2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockDetailResponse implements Parcelable{
    @SerializedName("01. symbol")
    @Expose
    public String symbol;
    @SerializedName("02. open")
    @Expose
    public String open;
    @SerializedName("03. high")
    @Expose
    public String high;
    @SerializedName("04. low")
    @Expose
    public String low;
    @SerializedName("05. price")
    @Expose
    public String price;
    @SerializedName("06. volume")
    @Expose
    public String volume;
    @SerializedName("07. latest trading day")
    @Expose
    public String latestTradingDay;
    @SerializedName("08. previous close")
    @Expose
    public String previousClose;
    @SerializedName("09. change")
    @Expose
    public String change;
    @SerializedName("10. change percent")
    @Expose
    public String changePercent;

    protected StockDetailResponse(Parcel in) {
        symbol = in.readString();
        open = in.readString();
        high = in.readString();
        low = in.readString();
        price = in.readString();
        volume = in.readString();
        latestTradingDay = in.readString();
        previousClose = in.readString();
        change = in.readString();
        changePercent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(symbol);
        dest.writeString(open);
        dest.writeString(high);
        dest.writeString(low);
        dest.writeString(price);
        dest.writeString(volume);
        dest.writeString(latestTradingDay);
        dest.writeString(previousClose);
        dest.writeString(change);
        dest.writeString(changePercent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StockDetailResponse> CREATOR = new Creator<StockDetailResponse>() {
        @Override
        public StockDetailResponse createFromParcel(Parcel in) {
            return new StockDetailResponse(in);
        }

        @Override
        public StockDetailResponse[] newArray(int size) {
            return new StockDetailResponse[size];
        }
    };
}

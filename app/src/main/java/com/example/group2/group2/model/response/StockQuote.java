
package com.example.group2.group2.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockQuote implements Parcelable {

    public final static Creator<StockQuote> CREATOR = new Creator<StockQuote>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StockQuote createFromParcel(Parcel in) {
            return new StockQuote(in);
        }

        public StockQuote[] newArray(int size) {
            return (new StockQuote[size]);
        }

    };
    @SerializedName("1. symbol")
    @Expose
    private String _1Symbol;
    @SerializedName("2. price")
    @Expose
    private String _2Price;
    @SerializedName("3. volume")
    @Expose
    private String _3Volume;
    @SerializedName("4. timestamp")
    @Expose
    private String _4Timestamp;

    protected StockQuote(Parcel in) {
        this._1Symbol = ((String) in.readValue((String.class.getClassLoader())));
        this._2Price = ((String) in.readValue((String.class.getClassLoader())));
        this._3Volume = ((String) in.readValue((String.class.getClassLoader())));
        this._4Timestamp = ((String) in.readValue((String.class.getClassLoader())));
    }

    public StockQuote() {
    }

    public String get1Symbol() {
        return _1Symbol;
    }

    public void set1Symbol(String _1Symbol) {
        this._1Symbol = _1Symbol;
    }

    public String get2Price() {
        return _2Price;
    }

    public void set2Price(String _2Price) {
        this._2Price = _2Price;
    }

    public String get3Volume() {
        return _3Volume;
    }

    public void set3Volume(String _3Volume) {
        this._3Volume = _3Volume;
    }

    public String get4Timestamp() {
        return _4Timestamp;
    }

    public void set4Timestamp(String _4Timestamp) {
        this._4Timestamp = _4Timestamp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_1Symbol);
        dest.writeValue(_2Price);
        dest.writeValue(_3Volume);
        dest.writeValue(_4Timestamp);
    }

    public int describeContents() {
        return 0;
    }

}

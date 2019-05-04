
package com.example.group2.group2.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StockQuoteResponse implements Parcelable {

    public final static Creator<StockQuoteResponse> CREATOR = new Creator<StockQuoteResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StockQuoteResponse createFromParcel(Parcel in) {
            return new StockQuoteResponse(in);
        }

        public StockQuoteResponse[] newArray(int size) {
            return (new StockQuoteResponse[size]);
        }

    };
    @SerializedName("Meta Data")
    @Expose
    private MetaData metaData;
    @SerializedName("Stock Quotes")
    @Expose
    private List<StockQuote> stockQuotes = null;

    protected StockQuoteResponse(Parcel in) {
        this.metaData = ((MetaData) in.readValue((MetaData.class.getClassLoader())));
        in.readList(this.stockQuotes, (StockQuote.class.getClassLoader()));
    }

    public StockQuoteResponse() {
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public List<StockQuote> getStockQuotes() {
        return stockQuotes;
    }

    public void setStockQuotes(List<StockQuote> stockQuotes) {
        this.stockQuotes = stockQuotes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(metaData);
        dest.writeList(stockQuotes);
    }

    public int describeContents() {
        return 0;
    }

}

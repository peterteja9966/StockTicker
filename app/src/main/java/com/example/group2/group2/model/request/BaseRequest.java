package com.example.group2.group2.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class BaseRequest {

    private String function = setFunction();

    @SerializedName("apikey")
    @Expose
    private String apikey = "BZ4EFVGM2D4OXBJM";

    abstract String setFunction();

}


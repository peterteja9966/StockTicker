package com.example.group2.group2.network;

import com.example.group2.group2.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class NetworkManager {

    protected final int READ_TIMEOUT_SEC = 20;
    protected final int WRITE_TIMEOUT_SEC = 20;
    protected final int CONNECTION_TIMEOUT_SEC = 30;

    protected Retrofit retrofit;

    /**
     * Default constructor that will use the base URL defined by the build config variable.
     */
    public NetworkManager() {
        this(true);
    }

    public NetworkManager(boolean authenticatorRequired) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * Custom constructor that will allow a developer to pass in a particular URL if needed.
     */
    public NetworkManager(String baseUrl) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getHttpClient())
                .build();
    }

    /**
     * Any other methods that are needed that are shared among the subclasses will go below this
     * comment. This might include methods to add the bearer token, or other headers to the
     * network calls.
     */
    protected Gson getGson() {
        return new GsonBuilder()
                .serializeNulls()
                .create();
    }

    protected OkHttpClient getHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT_SEC, TimeUnit.SECONDS);
        return builder.build();
    }
}

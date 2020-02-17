package com.amhsn.taskatw.data;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://pixabay.com/";
    private ApiInterface apiInterface;
    private static ApiClient INSTANCE;
    private Retrofit retrofit;

    public ApiClient() {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new ApiClient();
        }

        return INSTANCE;
    }

    public ApiInterface getAPI() {
        return retrofit.create(ApiInterface.class);
    }

}


package com.example.vibhu.newsshots;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class NewsAPI {

    private final static String url = "https://newsapi.org/v2/";


    public static Service service = null;

    public static Service getService()
    {
        if(service == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(Service.class);
        }

        return service;
    }



    public interface Service{
        @GET("top-headlines/")//?category=sports&country=in&apiKey=" + key)
        Call<User> getArticlesList(@Query("category")String category,
                                   @Query("country")String country,
                                   @Query("apiKey")String key);
    }

}

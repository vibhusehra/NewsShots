package com.example.vibhu.newsshots;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class NewsAPI {

    private final static String url = "https://newsapi.org/v2/top-headlines/";
    private final static  String key = "5d9c9b7e0e0b4b3ebaece4b1ee6944ff";

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
        @GET("?category=sports&country=in&apiKey=" + key)
        Call<User> getArticlesList();
    }

}

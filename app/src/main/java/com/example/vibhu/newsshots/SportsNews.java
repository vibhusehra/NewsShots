package com.example.vibhu.newsshots;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SportsNews extends AppCompatActivity {
    RecyclerView programmingList;
    List<Article> articles;
    private final static  String key = "5d9c9b7e0e0b4b3ebaece4b1ee6944ff";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_news);
        programmingList = findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        programmingList.setHasFixedSize(true);
        Fresco.initialize(this);
        getData();

    }

    private void getData()
    {
        Call<User> user = NewsAPI.getService().getArticlesList("sports","in",""+key);

        user.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Toast.makeText(SportsNews.this,"Success!",Toast.LENGTH_SHORT).show();
                articles = user.getArticles();

                for(Article a:articles){
                    Log.d("author","" + a.getAuthor());
                }
                programmingList.setAdapter(new RecyclerViewAdapter(articles, SportsNews.this));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(SportsNews.this,"Failure!",Toast.LENGTH_SHORT).show();;
            }
        });
    }
}

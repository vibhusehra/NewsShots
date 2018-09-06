package com.example.vibhu.newsshots;

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


public class News extends AppCompatActivity {
    RecyclerView newsList;
    List<Article> articles;
    private int option;
    private final static  String key = "5d9c9b7e0e0b4b3ebaece4b1ee6944ff";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //retrieving the option selected
        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            option = extras.getInt("OPTION_SELECTED_ID");
        }

        setContentView(R.layout.activity_news);
        newsList = findViewById(R.id.newsList);
        newsList.setLayoutManager(new LinearLayoutManager(this));
        newsList.setHasFixedSize(true);
        Fresco.initialize(this);
        checkOption();

    }

    private void checkOption()
    {
        String category;
        switch (option) {
            case 0:
                category = "sports";
                break;
            case 1:
                category = "technology";
                break;
            case 2:
                category = "business";
                break;
            case 3:
                category = "";
                break;
            case 4:
                category = "science";
                break;
            case 5:
                category = "entertainment";
                break;
            default:
                category = "sports";
        }
        getData(category);
    }


    void getData(String category)
    {
        Call<User> user = NewsAPI.getService().getArticlesList(category,"in",""+key);

        user.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Toast.makeText(News.this,"Success!",Toast.LENGTH_SHORT).show();
                articles = user.getArticles();

                for(Article a:articles){
                    Log.d("author","" + a.getAuthor());
                }
                newsList.setAdapter(new RecyclerViewAdapter(articles, News.this));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(News.this,"Failure!",Toast.LENGTH_SHORT).show();;
            }
        });

    }
}

package com.example.vibhu.newsshots;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout cardContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardContainer = findViewById(R.id.cardContainer);

        setEvent(cardContainer);
    }

    private void setEvent(GridLayout cardContainer){

        for(int i=0;i<cardContainer.getChildCount();i++){

            CardView cardView = (CardView) cardContainer.getChildAt(i);

            final int finali = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity(finali);
                    Log.i("result ","cardView clicked : " + Integer.toString(finali));
                }
            });
        }
    }

    public void openActivity(int i){
        Intent intent;
        switch (i){
            case 0:
                intent = new Intent(MainActivity.this,SportsNews.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(MainActivity.this,TechNews.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MainActivity.this,BusinessNews.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(MainActivity.this,GamingNews.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(MainActivity.this,ScienceNews.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(MainActivity.this,EntertainmentNews.class);
                startActivity(intent);
                break;
        }
    }
}

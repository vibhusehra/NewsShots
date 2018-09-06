package com.example.vibhu.newsshots;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    private List<Article> articles;
    private Context context;

    public RecyclerViewAdapter(List<Article> articles,Context context)
    {
        this.articles = articles;
        this.context = context;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.newsTitle.setText(articles.get(position).getTitle());
        holder.newsDescription.setText(articles.get(position).getDescription());
        Uri uri = Uri.parse(articles.get(position).getUrlToImage());
        if(uri != null){
            holder.simpleDraweeView.setImageURI(uri);
        }
        else{
            Toast.makeText(context,"END",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    protected class myViewHolder extends RecyclerView.ViewHolder{

        TextView newsDescription,newsTitle;
        SimpleDraweeView simpleDraweeView;

        public myViewHolder(View itemView) {
            super(itemView);
            newsDescription = itemView.findViewById(R.id.newsDescription);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            simpleDraweeView = itemView.findViewById(R.id.newsImg);

        }
    }
}

package com.itbrain.catalogmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itbrain.catalogmovie.R;
import com.itbrain.catalogmovie.activity.DetailMovieActivity;
import com.itbrain.catalogmovie.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    private List<Result> resultList;

    public MovieAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int i) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.item_movie,viewGroup,false);

        MovieAdapter.MyViewHolder viewHolder = new MovieAdapter.MyViewHolder(view);
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewGroup.getContext(), DetailMovieActivity.class);
                Result result = new Result();
                result.setOriginalTitle(resultList.get(viewHolder.getAdapterPosition()).getOriginalTitle());
                result.setOverview(resultList.get(viewHolder.getAdapterPosition()).getOverview());
                result.setPosterPath(resultList.get(viewHolder.getAdapterPosition()).getPosterPath());
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE,result);
                viewGroup.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  MovieAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTitle.setText(resultList.get(i).getTitle());
        myViewHolder.tvDescription.setText(resultList.get(i).getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w185" + resultList.get(i).getPosterPath()).into(myViewHolder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle,tvDescription;
        RelativeLayout relativeLayout;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            imgPoster = (ImageView) itemView.findViewById(R.id.imgMovie);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDeskription);
            relativeLayout = itemView.findViewById(R.id.layoutMovie);
        }
    }
}

package com.musarif.aplikasiberitabaru.adapter;

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
import com.musarif.aplikasiberitabaru.R;
import com.musarif.aplikasiberitabaru.activity.DetailMovieActivity;
import com.musarif.aplikasiberitabaru.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    private Context context;
    private List<Result> resultList;

    public MovieAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_movie, parent, false);


        MovieAdapter.MyViewHolder viewHolder = new MovieAdapter.MyViewHolder(view);
        viewHolder.layoutItemMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(),DetailMovieActivity.class);
                Result result = new Result();
                result.setVoteCount(resultList.get(viewHolder.getAbsoluteAdapterPosition()).getVoteCount());
                result.setVoteAverage(resultList.get(viewHolder.getAbsoluteAdapterPosition()).getVoteAverage());
                result.setReleaseDate(resultList.get(viewHolder.getAbsoluteAdapterPosition()).getReleaseDate());
                result.setOriginalTitle(resultList.get(viewHolder.getAbsoluteAdapterPosition()).getOriginalTitle());
                result.setOverview(resultList.get(viewHolder.getAbsoluteAdapterPosition()).getOverview());
                result.setPosterPath(resultList.get(viewHolder.getAbsoluteAdapterPosition()).getPosterPath());
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE,result);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvDescription.setText(resultList.get(position).getOverview());
        Glide.with(context).
                load("https://image.tmdb.org/t/p/w185" + resultList.get(position).getPosterPath()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription;
        RelativeLayout layoutItemMovie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemMovie = itemView.findViewById(R.id.layoutItemMovie);
            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDeskription);
        }
    }
}

package com.codinggeekers.moviesearchengine.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codinggeekers.moviesearchengine.Models.Movies;
import com.codinggeekers.moviesearchengine.MovieDetailsActivity;
import com.codinggeekers.moviesearchengine.R;
import com.codinggeekers.moviesearchengine.databinding.SampleLayoutMoviesBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.viewHolder>{

    ArrayList<Movies> list;
    Context context;

    public MoviesAdapter(ArrayList<Movies> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout_movies, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Movies movies = list.get(position);

        holder.binding.movieName.setText(movies.getMovieName());
        holder.binding.movieRating.setText(movies.getMovieRating());
//        Glide.with(context).load(movies.getMovieImg()).placeholder(R.drawable.placeholder).into(holder.binding.movieImg);
        Picasso.get().load(movies.getMovieImage()).placeholder(R.drawable.placeholder).into(holder.binding.movieImage);

        holder.binding.movieName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("movieName", movies.getMovieName());
                intent.putExtra("movieDescription", movies.getMovieDescription());
                intent.putExtra("movieRating", movies.getMovieRating());
                intent.putExtra("movieImage", movies.getMovieImage());
                intent.putExtra("movieLaunchDate", movies.getMovieLaunchDate());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        SampleLayoutMoviesBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = SampleLayoutMoviesBinding.bind(itemView);
        }

    }
}

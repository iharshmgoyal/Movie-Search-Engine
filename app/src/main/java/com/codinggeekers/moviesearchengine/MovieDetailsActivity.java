package com.codinggeekers.moviesearchengine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.codinggeekers.moviesearchengine.Models.Movies;
import com.codinggeekers.moviesearchengine.databinding.ActivityMovieDetailsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    ActivityMovieDetailsBinding binding;

    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();

        binding.movieName.setText(getIntent().getStringExtra("movieName"));
        binding.movieDescription.setText(getIntent().getStringExtra("movieDescription"));
        binding.movieLaunchDate.setText(getIntent().getStringExtra("movieLaunchDate"));
        binding.movieRating.setText(getIntent().getStringExtra("movieRating"));
        Picasso.get().load(getIntent().getStringExtra("movieImage")).placeholder(R.drawable.placeholder).into(binding.movieImage);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(MovieDetailsActivity.this, MainActivity.class));
    }
}
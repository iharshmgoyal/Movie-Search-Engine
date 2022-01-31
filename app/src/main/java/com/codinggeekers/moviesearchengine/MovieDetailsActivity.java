package com.codinggeekers.moviesearchengine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                auth.signOut();
                startActivity(new Intent(MovieDetailsActivity.this, LoginActivity.class));
                break;
            case R.id.addMovie:
                startActivity(new Intent(MovieDetailsActivity.this, AddMovieActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(MovieDetailsActivity.this, MainActivity.class));
    }
}
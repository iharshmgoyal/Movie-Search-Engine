package com.codinggeekers.moviesearchengine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.codinggeekers.moviesearchengine.Models.Users;
import com.codinggeekers.moviesearchengine.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = binding.email.getText().toString();
                password = binding.password.getText().toString();

                if (!email.matches("") && !password.matches("")) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("TAG", "onComplete: User Create Task Successful");
                                Users users = new Users();
                                users.setUsername(binding.userName.getText().toString());
                                users.setEmail(email);
                                users.setPassword(password);

                                String id = task.getResult().getUser().getUid();

                                database.getReference()
                                        .child("Users")
                                        .child(id)
                                        .setValue(users);
                                Toast.makeText(SignUpActivity.this, "User Created Successfully!!!", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                            }
                        }
                    });
                }
            }
        });

        binding.loginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

    }
}
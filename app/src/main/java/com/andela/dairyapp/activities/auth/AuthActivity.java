package com.andela.dairyapp.activities.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.andela.dairyapp.R;
import com.andela.dairyapp.activities.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mFirebaseAuth = FirebaseAuth.getInstance();


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
        navigateHome(currentUser);

    }

    private void registerUser(String email, String password){
        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mFirebaseAuth.getCurrentUser();
                    navigateHome(user);
                }else{
                    Toast.makeText(AuthActivity.this, "Failed to Create Account", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loginUser(String email, String password){
        mFirebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(AuthActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mFirebaseAuth.getCurrentUser();
                            navigateHome(user);
                        }else{
                            Toast.makeText(AuthActivity.this, "Sign In Failed.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void navigateHome(FirebaseUser user){
        if (user != null){
            Intent homeIntent = new Intent(this, HomeActivity.class);
            homeIntent.putExtra("user", user.getEmail());
            startActivity(homeIntent);
        }
    }
}

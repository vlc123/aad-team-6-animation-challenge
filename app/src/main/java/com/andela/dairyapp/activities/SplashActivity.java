package com.andela.dairyapp.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.andela.dairyapp.R;
import com.andela.dairyapp.activities.auth.AuthActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView mAppLogo;
    private TextView mWelcomeText;
    private View mLayout;
    private ProgressBar loadingProgressAnim;
    public static final int ANIM_DURATION = 1500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        mAppLogo = findViewById(R.id.app_logo);
        mWelcomeText = findViewById(R.id.intro_message);
        mLayout = findViewById(R.id.base_layout);
        loadingProgressAnim = findViewById(R.id.progressBar);

        mAppLogo.setVisibility(View.GONE);
        mWelcomeText.setVisibility(View.GONE);

        launchInitialAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toHomeActivity = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(toHomeActivity);
                finish();
            }
        }, 3500);


    }


    private void launchInitialAnimation() {
        ObjectAnimator logoFadeInAnimator = ObjectAnimator.ofFloat(mAppLogo, "alpha", 0.0f, 1.0f);
        logoFadeInAnimator.setDuration(ANIM_DURATION)
                .setInterpolator(new AccelerateDecelerateInterpolator());

        // This anim is used for moving the logo downwards
        ObjectAnimator logoDownwardMovementAnimator = ObjectAnimator.ofFloat(mAppLogo, "translationY", 0f, 100f);
        logoDownwardMovementAnimator.setDuration(ANIM_DURATION)
                .setInterpolator(new AccelerateDecelerateInterpolator());


        ObjectAnimator textFadeInAnimator = ObjectAnimator.ofFloat(mWelcomeText, "alpha", 0.0f, 1.0f);
        textFadeInAnimator.setDuration(ANIM_DURATION);

        ObjectAnimator textDownwardMovementAnimator = ObjectAnimator.ofFloat(mWelcomeText, "translationY", 0f, 100f);
        textDownwardMovementAnimator.setDuration(ANIM_DURATION);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(logoFadeInAnimator, logoDownwardMovementAnimator, textFadeInAnimator, textDownwardMovementAnimator);
        set.start();

        mAppLogo.setVisibility(View.VISIBLE);
        mWelcomeText.setVisibility(View.VISIBLE);
    }
}

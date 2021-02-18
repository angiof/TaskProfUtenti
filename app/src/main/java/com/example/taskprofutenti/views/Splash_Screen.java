package com.example.taskprofutenti.views;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.taskprofutenti.R;
import com.example.taskprofutenti.databinding.ActivitySplashScreenBinding;

public class Splash_Screen extends AppCompatActivity {
ActivitySplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        getSupportActionBar().hide();


        binding.animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {


            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                startActivity(new Intent(Splash_Screen.this,MainActivity.class));


            }
        });






    }
}
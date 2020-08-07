package com.mei.aspectjdemo;

import com.mei.aspectjdemo.annotation.AnnotationAopActivity;
import com.mei.aspectjdemo.noannotation.NoAnnotationAopActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAnnotation(View view) {
        startActivity(new Intent(this, AnnotationAopActivity.class));
    }

    public void noAnnotation(View view) {
        startActivity(new Intent(this, NoAnnotationAopActivity.class));
    }
}
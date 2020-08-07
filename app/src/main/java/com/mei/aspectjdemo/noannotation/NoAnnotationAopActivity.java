package com.mei.aspectjdemo.noannotation;

import com.mei.aspectjdemo.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

/**
 * 无入侵的方式，实现切面，不通过注解，
 */
public class NoAnnotationAopActivity extends AppCompatActivity {

    private static final String TAG = "NoAnnotationAopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_annotation_aop);
        Log.i(TAG, "onCreate: 被执行");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: 被执行");
    }


}
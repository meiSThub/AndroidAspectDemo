package com.mei.aspectjdemo.annotation;

import com.mei.aspectjdemo.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * 入侵的方式，实现切面，入侵意思就是需要通过注解配合的方式，实现切面
 */
public class AnnotationAopActivity extends AppCompatActivity {

    private static final String TAG = "AnnotationAopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation_aop);
    }


    @BehaviorTrace("摇一摇")
    public void mShake(View view) {
        Log.i(TAG, "mShake: 方法执行");
        SystemClock.sleep(new Random().nextInt(2000));
    }

    @BehaviorTrace("语音消息")
    public void mAudio(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }

    @UserInfoTrace("用户视频")
    @BehaviorTrace("视频消息")
    public void mVideo(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }

    @BehaviorTrace("说说功能")
    public void saySomething(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }

}
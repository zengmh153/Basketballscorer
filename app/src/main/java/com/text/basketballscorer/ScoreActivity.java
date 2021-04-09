package com.text.basketballscorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }
    public void show(){
        Log.i(TAG, "show: score="+score);
        TextView show=findViewById(R.id.score);

    }
    public void btn3 (View v){
        score +=3;
    }
    public void btn2(View v){
        score +=2;
    }
    public void btn1(View v){
        score +=1;
    }

}
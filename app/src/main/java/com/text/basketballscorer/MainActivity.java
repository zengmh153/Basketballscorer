package com.text.basketballscorer;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  final  int scoreArray[]={1,2,3};
    private  int lastScore_a,lastScore_b,score_a,score_b;
    private Button btna_1,btna_2,btna_3,btnb_1,btnb_2,btnb_3,button2;
    private TextView test_score_a,test_score_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inintView();
    }

    private void inintView() {
        btna_1=findViewById(R.id.btna_1);
        btna_2=findViewById(R.id.btna_2);
        btna_3=findViewById(R.id.btna_3);
        btnb_1=findViewById(R.id.btnb_1);
        btnb_2=findViewById(R.id.btnb_2);
        btnb_3=findViewById(R.id.btnb_3);
        button2=findViewById(R.id.button2);


        test_score_a=findViewById(R.id.score_a);
        test_score_b=findViewById(R.id.score_b);

        btna_1.setOnClickListener(this);
        btna_2.setOnClickListener(this);
        btna_3.setOnClickListener(this);
        btnb_1.setOnClickListener(this);
        btnb_2.setOnClickListener(this);
        btnb_3.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btna_1:
                scoreAdd(0,scoreArray[0]);
                break;
            case R.id.btna_2:
                scoreAdd(0,scoreArray[1]);
                break;
            case R.id.btna_3:
                scoreAdd(0,scoreArray[2]);
                break;
            case  R.id.btnb_1:
                scoreAdd(1,scoreArray[0]);
                break;
            case  R.id.btnb_2:
                scoreAdd(1,scoreArray[1]);
                break;
            case  R.id.btnb_3:
                scoreAdd(1,scoreArray[2]);
                break;
            case  R.id.button2:
                score_a=0;
                score_b=0;
                ShowText();
                break;

            default:
                break;
        }
    }

    private void cancel() {
        if (score_a!=0&&score_a-lastScore_a>=0){
            score_a-=lastScore_a;
        }
        if (score_b!=0&&score_b-lastScore_b>=0){
            score_b-=lastScore_b;
        }
        ShowText();
    }


    private   void  scoreAdd(int Tage,int score){
        if (Tage==0||Tage==1){
            if (Tage==0){
                lastScore_b=0;
                lastScore_a=score;
                score_a+=lastScore_a;
            }else if (Tage==1){
                lastScore_a=0;
                lastScore_b=score;
                score_b+=lastScore_b;
            }
            ShowText();
        }
    }
    private  void ShowText(){
        test_score_a.setText(Integer.toString(score_a));
        test_score_b.setText(Integer.toString(score_b));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String scora=((TextView)findViewById(R.id.score_a)).getText().toString();
        String scorb=((TextView)findViewById(R.id.score_a)).getText().toString();
        outState.putString("teama_score",scora);
        outState.putString("teamb_score",scorb);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String scora=savedInstanceState.getString("teama_score");
        String scorb=savedInstanceState.getString("teamb_score");
        ((TextView)findViewById(R.id.score_a)).setText(scora);
        ((TextView)findViewById(R.id.score_b)).setText(scorb);
    }
}

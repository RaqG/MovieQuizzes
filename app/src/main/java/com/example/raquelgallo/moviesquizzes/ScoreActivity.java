package com.example.raquelgallo.moviesquizzes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Raquel Gallo on 05/01/2018.
 */

public class ScoreActivity extends AppCompatActivity {

    @BindView(R.id.txt_total_score)
    public TextView finalScore;

    @BindView(R.id.txt_hits)
    public TextView hits;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ButterKnife.bind(this);

        Intent it = getIntent();
        float score = Float.parseFloat(it.getExtras().get("score").toString());
        int totalQuestions = Integer.parseInt(it.getExtras().get("totalOfQuestions").toString());

        String scoreMsg = getResources().getString(R.string.finalScore) + " " + score;
        String goodHitsMsg;
        String badHitsMsg;
        long roundedScore = Math.round(Math.floor(score));
        if (score >= (totalQuestions / 2)) {
            goodHitsMsg = getResources().getString(R.string.goodHits) + " " + roundedScore + " " +
                    getResources().getString(R.string.of) + " " + totalQuestions + " " +
                    getResources().getString(R.string.questions);
            hits.setText(goodHitsMsg);
        } else {
            badHitsMsg = getResources().getString(R.string.badHits) + " " + roundedScore + " " +
                    getResources().getString(R.string.of) + " " + totalQuestions + " " +
                    getResources().getString(R.string.questions);
            hits.setText(badHitsMsg);
        }
        finalScore.setText(scoreMsg);
    }

    @OnClick(R.id.restart_btn)
    public void onRestartGame(){
        Intent intent = new Intent(this, QuestionsActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.example.android.meowcount;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreKyo = 0;
    int scoreAlice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForKyo(scoreKyo);
        displayForAlice(scoreAlice);
    }

    //SCORE COUNT FOR KYO (CAT 1)

    /***Adding 1 point to Cat 1 score count***/
    public void addMeowForKyo(View view) {
        scoreKyo = scoreKyo + 1;
        displayForKyo(scoreKyo);
    }

    /***Adding 3 points to Cat 1 score count***/
    public void addPurrForKyo(View view) {
        scoreKyo = scoreKyo + 3;
        displayForKyo(scoreKyo);
    }

    /***Subtracting 2 points from Cat 1 score count***/
    public void pointsReducedForKyo(View view) {
        scoreKyo = scoreKyo - 2;
        //NOTE: Count cannot go below 0
        if (scoreKyo <= 0) {
            scoreKyo = 0;
        }
        displayForKyo(scoreKyo);
    }

    //SCORE COUNT FOR ALICE (CAT 2)

    /***Adding 1 point to Cat 2 score count***/
    public void addSqueekForAlice(View view) {
        scoreAlice = scoreAlice + 1;
        displayForAlice(scoreAlice);
    }

    /***Adding 3 points to Cat 2 score count***/
    public void addPurrForAlice(View view) {
        scoreAlice = scoreAlice + 3;
        displayForAlice(scoreAlice);
    }

    /***Subtracting 2 points from Cat 2 score count***/
    public void pointsReducedForAlice(View view) {
        scoreAlice = scoreAlice - 2;
        //NOTE: Count cannot go below 0
        if (scoreAlice <= 0) {
            scoreAlice = 0;
        }
        displayForAlice(scoreAlice);
    }

    /***Resetting score count for CAT 1 & CAT 2 back to 0 points.***/
    public void resetScore(View view) {
        scoreKyo = 0;
        scoreAlice = 0;
        displayForKyo(scoreKyo);
        displayForAlice(scoreAlice);
    }

    /*** Displays the given score for CAT 1.***/
    public void displayForKyo(int score) {
        TextView scoreView = (TextView) findViewById(R.id.kyo_score);
        scoreView.setText(String.valueOf(score));
    }

    /*** Displays the given score for CAT 2.***/
    public void displayForAlice(int score) {
        TextView scoreView = (TextView) findViewById(R.id.alice_score);
        scoreView.setText(String.valueOf(score));
    }

}

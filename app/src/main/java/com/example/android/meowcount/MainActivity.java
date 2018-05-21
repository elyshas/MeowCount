package com.example.android.meowcount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // GRADER COMMENT: "In Java, when initializing a global variable of type int, by default, its value is 0. No need to add = 0."
    /** Initializing Kyo and Alice scores, set to 0 **/
    int scoreKyo;
    int scoreAlice;

    /** Creating a label to be called on for the savedInstantState (adding a key value pair lower down) **/
    static final String SCORE_KYO = "scoreKyo";
    static final String SCORE_ALICE = "scoreAlice";

    /** OnCreate, reference saved instances or create new **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // If savedInstanceState exists, then reference the below labels and values in order to save scores upon rotation
        if (savedInstanceState != null) {
            scoreKyo = savedInstanceState.getInt(SCORE_KYO);
            scoreAlice = savedInstanceState.getInt(SCORE_ALICE);
       // Else, start at 0
        } else {
            scoreKyo = 0;
            scoreAlice = 0;
        }

        // Oncreate (on startup) set these scores to above mentioned ints
        displayForKyo(scoreKyo);
        displayForAlice(scoreAlice);
    }

    // Calling on the label and adding the int value for both scores (which was created at the top).
    /** Saving instance for when rotating between portrait and landscape **/
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SCORE_KYO, scoreKyo);
        savedInstanceState.putInt(SCORE_ALICE, scoreAlice);
        // Call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    // SCORE COUNT FOR KYO (CAT 1)

    /** Adding 1 point to Cat 1 score count **/
    public void addMeowForKyo(View view) {
        scoreKyo = scoreKyo + 1;
        displayForKyo(scoreKyo);
    }

    /** Adding 3 points to Cat 1 score count **/
    public void addPurrForKyo(View view) {
        scoreKyo = scoreKyo + 3;
        displayForKyo(scoreKyo);
    }

    /** Subtracting 2 points from Cat 1 score count **/
    public void pointsReducedForKyo(View view) {
        scoreKyo = scoreKyo - 2;
        //NOTE: Count cannot go below 0
        if (scoreKyo <= 0) {
            scoreKyo = 0;
            Toast.makeText(this, "Score count cannot go below 0.", Toast.LENGTH_LONG).show();
        }
        displayForKyo(scoreKyo);
    }

    // SCORE COUNT FOR ALICE (CAT 2)

    /** Adding 1 point to Cat 2 score count **/
    public void addSqueekForAlice(View view) {
        scoreAlice = scoreAlice + 1;
        displayForAlice(scoreAlice);
    }

    /** Adding 3 points to Cat 2 score count **/
    public void addPurrForAlice(View view) {
        scoreAlice = scoreAlice + 3;
        displayForAlice(scoreAlice);
    }

    /** Subtracting 2 points from Cat 2 score count **/
    public void pointsReducedForAlice(View view) {
        scoreAlice = scoreAlice - 2;
        // NOTE: Count cannot go below 0
        if (scoreAlice <= 0) {
            scoreAlice = 0;
            Toast.makeText(this, "Score count cannot go below 0.", Toast.LENGTH_LONG).show();
        }
        displayForAlice(scoreAlice);
    }

    /** Resetting score count for CAT 1 & CAT 2 back to 0 points. **/
    public void resetScore(View view) {
        scoreKyo = 0;
        scoreAlice = 0;
        displayForKyo(scoreKyo);
        displayForAlice(scoreAlice);
    }

    /** Displays the given score for CAT 1. **/
    public void displayForKyo(int score) {
        TextView scoreView = (TextView) findViewById(R.id.kyo_score);
        scoreView.setText(String.valueOf(score));
    }

    /** Displays the given score for CAT 2. **/
    public void displayForAlice(int score) {
        TextView scoreView = (TextView) findViewById(R.id.alice_score);
        scoreView.setText(String.valueOf(score));
    }

}

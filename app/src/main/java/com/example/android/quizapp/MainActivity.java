package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitQuiz(View view) {

        int correctAnswers = checkAnswers();

        String message;

        if (correctAnswers == 6) {
            message = "You answered everything correctly. You win!";
        } else {
            message = "You answered correctly " + correctAnswers + " out of 6.";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private int checkAnswers() {
        int correctAnswers = 0;

        correctAnswers += checkQuestion1();
        correctAnswers += checkQuestion2();
        correctAnswers += checkQuestion3();
        correctAnswers += checkQuestion4();
        correctAnswers += checkQuestion5();
        correctAnswers += checkQuestion6();

        return correctAnswers;
    }

    private int checkQuestion1() {
        String userAnswer = ((EditText) findViewById(R.id.q1_answer)).getText().toString();

        userAnswer = userAnswer.toLowerCase().trim();

        if (userAnswer.equals("queen")) {
            return 1;
        }

        return 0;
    }

    private int checkQuestion2() {

        Boolean correctAnswer1 = ((CheckBox) findViewById(R.id.q2_answer_correct1)).isChecked();
        Boolean incorrectAnswer1 = ((CheckBox) findViewById(R.id.q2_answer_incorrect1)).isChecked();
        Boolean correctAnswer2 = ((CheckBox) findViewById(R.id.q2_answer_correct2)).isChecked();
        Boolean incorrectAnswer2 = ((CheckBox) findViewById(R.id.q2_answer_incorrect2)).isChecked();

        if (correctAnswer1 && !incorrectAnswer1 && correctAnswer2 && !incorrectAnswer2) {
            return 1;
        }

        return 0;
    }

    private int checkQuestion3() {
        Boolean correctAnswer1 = ((CheckBox) findViewById(R.id.q3_correct1)).isChecked();
        Boolean correctAnswer2 = ((CheckBox) findViewById(R.id.q3_correct2)).isChecked();
        Boolean incorrectAnswer1 = ((CheckBox) findViewById(R.id.q3_incorrect1)).isChecked();

        if (correctAnswer1 && !incorrectAnswer1 && correctAnswer2) {
            return 1;
        }

        return 0;
    }

    private int checkQuestion4() {
        Boolean correctAnswer1 = ((CheckBox) findViewById(R.id.q4_correct1)).isChecked();
        Boolean correctAnswer2 = ((CheckBox) findViewById(R.id.q4_correct2)).isChecked();
        Boolean incorrectAnswer1 = ((CheckBox) findViewById(R.id.q4_incorrect1)).isChecked();

        if (correctAnswer1 && !incorrectAnswer1 && correctAnswer2) {
            return 1;
        }

        return 0;
    }


    private int checkQuestion5() {
        Boolean correctAnswer = ((RadioButton) findViewById(R.id.q5_correct)).isChecked();

        if (correctAnswer) {
            return 1;
        }

        return 0;
    }

    private int checkQuestion6() {
        Boolean correctAnswer = ((RadioButton) findViewById(R.id.q6_correct)).isChecked();

        if (correctAnswer) {
            return 1;
        }

        return 0;
    }
}

package com.example.quizapp2;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizResult extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_result);

        final ImageView backBtn2 = findViewById(R.id.backBtn2);
        final AppCompatButton startNewBtn = findViewById(R.id.startNewQuizBtn);
        final TextView correctAnswer = findViewById(R.id.correctAnswer);
        final TextView incorrectAnswer = findViewById(R.id.incorrectAnswer);
        final ProgressBar circularProgressBar = findViewById(R.id.progressBar);
        final TextView progressText = findViewById(R.id.progressText);
        final TextView percentageText = findViewById(R.id.percentageText);
        final TextView congratulationText = findViewById(R.id.congratulationIcon);

        Typeface typeface = ResourcesCompat.getFont(this,R.font.dancingscript);
        congratulationText.setTypeface(typeface);


        try {
            final int getCorrectAnswer = getIntent().getIntExtra("correct", 0);
            final int getIncorrectAnswer = getIntent().getIntExtra("incorrect", 0);
            final int totalQuestions = getCorrectAnswer + getIncorrectAnswer;

            // Calculate the percentage of correct and incorrect answers
            int correctPercentage = (int) ((double) getCorrectAnswer / totalQuestions * 100);
            int incorrectPercentage = (int) ((double) getIncorrectAnswer / totalQuestions * 100);
            if (getCorrectAnswer == -1 || getIncorrectAnswer == -1) {
                // Log the issue and show a message to help identify the problem
                Log.e(TAG, "Intent extras not found or incorrect.");
                Toast.makeText(this, "Error: Unable to retrieve quiz results.", Toast.LENGTH_LONG).show();
            } else {
                correctAnswer.setText(String.valueOf("Correct Answer: " + getCorrectAnswer));
                incorrectAnswer.setText(String.valueOf("Wrong Answer: " + getIncorrectAnswer));
                percentageText.setText(String.valueOf("You got " + correctPercentage + "% of the answers correct.\nCongratulation!"));

                circularProgressBar.setProgress(correctPercentage);
                circularProgressBar.setSecondaryProgress(correctPercentage + incorrectPercentage);

                // Update progress text
                progressText.setText(getCorrectAnswer + "/" + totalQuestions);

            }
        } catch (Exception e) {
            // Catch any exceptions, log them and show an error message
            Log.e(TAG, "Exception while retrieving intent data", e);
            Toast.makeText(this, "An error occurred while loading results.", Toast.LENGTH_LONG).show();
        }

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResult.this, MainActivity.class));
                finish();
            }
        });
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuizResult.this, MainActivity.class));
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuizResult.this, MainActivity.class));
        finish();

    }
}
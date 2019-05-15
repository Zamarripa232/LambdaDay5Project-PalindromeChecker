package com.example.palindromechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editToCheck;
    Button   buttonCheck;
    TextView textResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editToCheck = findViewById(R.id.edit_to_check);
        buttonCheck = findViewById(R.id.button_check);
        textResults = findViewById(R.id.text_results);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPalindrome(editToCheck.getText().toString())){
                    textResults.setText(R.string.success_text);
                } else {
                    textResults.setText(R.string.failure_text);
                }
            }
        });
    }

    boolean isPalindrome(String toCheck){
        toCheck = stringCleaner(toCheck);

        for (int i = 0; i < (toCheck.length() / 2); i++){
            if (toCheck.charAt(i) != toCheck.charAt(toCheck.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    String stringCleaner(String unclean){
        return unclean.toLowerCase()
                      .replaceAll("\\s","")
                      .replaceAll("[^a-zA-Z0-9]","");
    }
}

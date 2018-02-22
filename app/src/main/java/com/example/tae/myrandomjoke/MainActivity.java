package com.example.tae.myrandomjoke;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tae.myrandomjoke.random_jokes.RandomJokeFragment;
import com.example.tae.myrandomjoke.text_input.TextInputFragment;

public class MainActivity extends AppCompatActivity {

    Bundle savedInstanceState;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        Button btnRandom = findViewById(R.id.btnRandom);
        Button btnTextInput = findViewById(R.id.btnTextInput);



        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomJoke();
            }
        });

        btnTextInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInput();
            }
        });

    }

    private void randomJoke()
            {
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragmentContainer, new RandomJokeFragment())
                            .disallowAddToBackStack()
                            .commit();
                }
            }

    private void textInput()
    {
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainer, new TextInputFragment())
                        .disallowAddToBackStack()
                        .commit();
            }
        }
}

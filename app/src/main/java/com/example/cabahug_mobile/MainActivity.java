package com.example.cabahug_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    RelativeLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg = findViewById(R.id.activity_main);
        bg.setBackgroundColor(Color.WHITE);
        buttonClicked();

    }

    public void buttonClicked(){
        button = findViewById(R.id.change_button);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show();
        bg = findViewById(R.id.activity_main);
        int color = ((ColorDrawable) bg.getBackground()).getColor();

        if (color == Color.RED){
            bg.setBackgroundColor(Color.BLUE);
        }
        else {
            bg.setBackgroundColor(Color.RED);
        }
    }
}
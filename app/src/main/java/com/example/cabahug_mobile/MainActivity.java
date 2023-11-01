package com.example.cabahug_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    RelativeLayout bg;
    int colorindex = 0;
    int count = 1;
    TextView text;
    int delayInSeconds = 3; // Set the initial delay in seconds
    int secondsLeft = delayInSeconds; // Initialize the seconds left
    Handler handler;
    ArrayList<Integer> colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        text = findViewById(R.id.counter);
        text.setText("Seconds left: " + delayInSeconds);
        bg = findViewById(R.id.activity_main);
        bg.setBackgroundColor(colors.get(colorindex));
        button = findViewById(R.id.change_button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        colorindex++;

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (colors.size() > 0) {

                    // Ensure the color index stays within bounds
                    colorindex = (colorindex + colors.size()) % colors.size();

                    if (delayInSeconds == 0) {
                        // Change the background color to the current color
                        bg.setBackgroundColor(colors.get(colorindex));

                        if (colorindex <= colors.size() - 1 && count == 1) {
                            if (colorindex != 2) {
                                colorindex++;
                            } else {
                                colorindex--;
                                count++;
                            }
                        } else {
                            colorindex--;
                            count--;
                        }

                        // Reset the delay to the initial value
                        delayInSeconds = 3;
                    }

                    // Set the text to the number of seconds left
                    // 'yourTextView' should be replaced with your TextView
                    text.setText("Seconds left: " + delayInSeconds);

                    // Schedule the next color change and seconds update after 1 second
                    handler.postDelayed(this, 1000); // Update every second
                    delayInSeconds--;
                }
            }
        }, 0);
    }
}

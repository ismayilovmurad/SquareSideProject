package com.martiandeveloper.squareside;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    private FrameLayout activityMainContainerFL;
    private EditText activityMainNumberET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = new MyView(this, 160F);

        activityMainContainerFL = findViewById(R.id.activity_main_containerFL);
        activityMainNumberET = findViewById(R.id.activity_main_numberET);

        activityMainContainerFL.addView(myView);

        findViewById(R.id.activity_main_drawMBTN).setOnClickListener(v -> {

            if ((activityMainNumberET.getText() != null && !activityMainNumberET.getText().toString().equals(""))) {

                try {

                    if (Float.parseFloat(activityMainNumberET.getText().toString()) >= 0.5 && Float.parseFloat(activityMainNumberET.getText().toString()) <= 4) {

                        ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                        activityMainContainerFL.removeView(myView);
                        myView = new MyView(MainActivity.this, Float.parseFloat(activityMainNumberET.getText().toString()) * 160F);
                        activityMainContainerFL.addView(myView);

                    } else
                        Toast.makeText(MainActivity.this, "Please enter a number between 0.5 and 4", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Please enter a number between 0.5 and 4", Toast.LENGTH_SHORT).show();
                }


            }

        });

    }

}

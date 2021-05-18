package com.martiandeveloper.squareside;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyView myView;
    private MyViewDefault myViewDefault;

    private FrameLayout activityMainDefaultContainerFL, activityMainContainerFL;
    private EditText activityMainNumberET;

    private float defaultSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainDefaultContainerFL = findViewById(R.id.activity_main_defaultContainerFL);
        activityMainContainerFL = findViewById(R.id.activity_main_containerFL);
        activityMainNumberET = findViewById(R.id.activity_main_numberET);

        findViewById(R.id.activity_main_drawMBTN).setOnClickListener(v -> {

            if ((activityMainNumberET.getText() != null && !activityMainNumberET.getText().toString().equals(""))) {

                try {

                    if (Float.parseFloat(activityMainNumberET.getText().toString()) >= 0.5 && Float.parseFloat(activityMainNumberET.getText().toString()) <= 4) {

                        ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                        if (myViewDefault == null) {
                            defaultSide = Float.parseFloat(activityMainNumberET.getText().toString()) * 40F;

                            myViewDefault = new MyViewDefault(MainActivity.this, defaultSide);
                            activityMainDefaultContainerFL.addView(myViewDefault);
                        } else {
                            if (myView != null) activityMainContainerFL.removeView(myView);

                            myView = new MyView(MainActivity.this, Float.parseFloat(activityMainNumberET.getText().toString()) * defaultSide);
                            activityMainContainerFL.addView(myView);
                        }

                    } else
                        Toast.makeText(MainActivity.this, "Please enter a number between 0.5 and 4", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Please enter a number between 0.5 and 4", Toast.LENGTH_SHORT).show();
                }


            }

        });

    }

}

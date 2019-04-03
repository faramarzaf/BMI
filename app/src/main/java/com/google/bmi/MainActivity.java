package com.google.bmi;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    Button btn_calc;
    TextView result, explain;
    RadioGroup radio_group;
    BmiComputer bmiComputer = new BmiComputer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == btn_calc.getId()) {

                    RadioGroup radio_group = findViewById(R.id.radio_group);
                    int radioButtonID = radio_group.getCheckedRadioButtonId();
                    RadioButton radioButton = radio_group.findViewById(radioButtonID);
                    String selectedtext = (String) radioButton.getText();

                    if (selectedtext.equals("Metric system")) {

                        Float javab = bmiComputer.bmi_result_metric(Float.valueOf(height.getText().toString()), Float.valueOf(weight.getText().toString()));
                        String javab2 = String.format("%.1f", javab);
                        result.setText("BMI : " + String.valueOf(javab2));

                        if (javab < 18.5) {
                            explain.setText("You are underweight");
                            explain.setTextColor(Color.rgb(129, 129, 129));

                        } else if (javab > 18.5 && javab < 24.9) {
                            explain.setText("You are normal");
                            explain.setTextColor(Color.rgb(46, 194, 52));

                        } else if (javab > 25 && javab < 29.9) {
                            explain.setText("You are overweight");
                            explain.setTextColor(Color.rgb(227, 177, 50));

                        } else if (javab > 30) {
                            explain.setText("You are obese");
                            explain.setTextColor(Color.rgb(226, 27, 24));
                        }


                    } else if (selectedtext.equals("English system")) {

                        Float javab = bmiComputer.bmi_result_english(Float.valueOf(height.getText().toString()), Float.valueOf(weight.getText().toString()));
                        String javab2 = String.format("%.1f", javab);
                        result.setText("BMI : " + String.valueOf(javab2));

                        if (javab < 18.5) {
                            explain.setText("You are underweight");
                            explain.setTextColor(Color.rgb(129, 129, 129));

                        } else if (javab > 18.5 && javab < 24.9) {
                            explain.setText("You are normal");
                            explain.setTextColor(Color.rgb(46, 194, 52));

                        } else if (javab > 25 && javab < 29.9) {
                            explain.setText("You are overweight");
                            explain.setTextColor(Color.rgb(227, 177, 50));

                        } else if (javab > 30) {
                            explain.setText("You are obese");
                            explain.setTextColor(Color.rgb(226, 27, 24));
                        }

                    }

                }

            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.help) {
            Intent intentHelp = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intentHelp);
        }
        return super.onOptionsItemSelected(item);
    }


    private void bind() {
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        explain = findViewById(R.id.explain);
        btn_calc = findViewById(R.id.btn_calc);
        result = findViewById(R.id.result);
        radio_group = findViewById(R.id.radio_group);

    }

}

package com.google.bmi.mvp_bmi;

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

import com.google.bmi.HelpActivity;
import com.google.bmi.MainActivity;
import com.google.bmi.R;

public class BMI_mvp_Activity extends AppCompatActivity implements Contract.View, View.OnClickListener {

    EditText height, weight;
    Button btn_calc;
    TextView result_bmi, explain;
    RadioGroup radio_group;

    Contract.Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_mvp_);
        presenter.attachView(this);
        bind();
        btn_calc.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.help) {
            Intent intentHelp = new Intent(BMI_mvp_Activity.this, Help_mvp_Activity.class);
            startActivity(intentHelp);
        }
        return super.onOptionsItemSelected(item);
    }

    private void bind() {
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        explain = findViewById(R.id.explain);
        btn_calc = findViewById(R.id.btn_calc);
        result_bmi = findViewById(R.id.result_bmi);
        radio_group = findViewById(R.id.radio_group);
    }

    @Override
    public void onBmiReceived(float result) {
        String result2 = String.format("%.1f", result);
        result_bmi.setText("BMI : " + result2);

        if (result < 18.5) {
            explain.setText("You are underweight");
            explain.setTextColor(Color.rgb(129, 129, 129));

        } else if (result > 18.5 && result < 24.9) {
            explain.setText("You are normal");
            explain.setTextColor(Color.rgb(46, 194, 52));

        } else if (result > 25 && result < 29.9) {
            explain.setText("You are overweight");
            explain.setTextColor(Color.rgb(227, 177, 50));

        } else if (result > 30) {
            explain.setText("You are obese");
            explain.setTextColor(Color.rgb(226, 27, 24));
        }

    }

    @Override
    public void onClick(View v) {
        if (weight.length() == 0) {
            weight.setError("Enter weight");
        }

        if (height.length() == 0) {
            height.setError("Enter height");

        } else if (weight.length() != 0 & height.length() != 0) {

            RadioGroup radio_group = findViewById(R.id.radio_group);
            int radioButtonID = radio_group.getCheckedRadioButtonId();
            RadioButton radioButton = radio_group.findViewById(radioButtonID);
            String selectedtext = (String) radioButton.getText();

            if (selectedtext.equals("Metric system")) {
                presenter.get_bmi_metric(Float.valueOf(height.getText().toString()), Float.valueOf(weight.getText().toString()));

            } else if (selectedtext.equals("English system")) {

                presenter.get_bmi_english(Float.valueOf(height.getText().toString()), Float.valueOf(weight.getText().toString()));

            }
        }
    }
}

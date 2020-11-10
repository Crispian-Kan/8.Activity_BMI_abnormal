package com.example.project_bmi_abnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void BMI_compute(View v){

        EditText height = (EditText)findViewById(R.id.input_height);
        EditText weight = (EditText)findViewById(R.id.input_weight);

        Intent intent = new Intent(this, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("Height", height.getText().toString());
        bundle.putString("Weight", weight.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);//傳值至下一頁
    }
}
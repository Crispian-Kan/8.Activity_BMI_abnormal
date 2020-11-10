package com.example.project_bmi_abnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bmi_Answer();
    }
    //返回上一頁
    public void back_pageA(View v){
        finish();
    }
    private void bmi_Answer(){

        double height;
        double weight;
        double bmi ;
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null){
            DecimalFormat nf = new DecimalFormat("0.00");
            height = Double.parseDouble(bundle.getString("Height")) ;
            weight = Double.parseDouble(bundle.getString("Weight"));

            bmi = weight / (height * height);

            TextView output_BMI_value = (TextView)findViewById(R.id.output_BMI_value);
            output_BMI_value.setText(nf.format(bmi));
            TextView abnormal = (TextView)findViewById(R.id.output_result);
            //判斷式
            if (bmi < 18){
                abnormal.setText("異常(體重過輕)");
                abnormal.setTextColor(Color.RED);
            }
            else if (bmi > 24){
                abnormal.setText("異常(體重過重)");
                abnormal.setTextColor(Color.RED);
            }
            else
                abnormal.setText("正常(體重正常)");
                abnormal.setTextColor(Color.BLUE);
        }
    }
}
package com.hale.a150116841hw1;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.text.DecimalFormat;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Result extends AppCompatActivity {

    TextView bmiValue,textCondition, textComment ;
    String conditionId,comment;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        bmiValue = (TextView) findViewById(R.id.bmiValue);
        textCondition = (TextView) findViewById(R.id.conditionId);
        textComment = (TextView) findViewById(R.id.comment);
        Intent i = getIntent();
        Bundle b = i.getExtras();

        if (b != null)
        {
            conditionId = (String) b.get("_bmi");
            comment = (String) b.get("_bmi");
            bmi = Double.parseDouble(conditionId);
            bmi = Double.parseDouble(comment);
            DecimalFormat formatter = new DecimalFormat("00.0");
            bmiValue.setText(formatter.format(bmi));
            populateBmi(bmi);
        }
    }

    public void populateBmi (double bmi)

    {
        String condition = "";
        String advice = "";
        if (bmi < 18.5) {
            condition = "Underweight";
            advice = "You need to be feed more healthy.";
        } else if (18.5 <= bmi && bmi < 23) {
            condition = "Normal ";
            advice = "You're doing great,you just need to keep it.";
        } else if (23 <= bmi && bmi < 25) {
            condition = "Normal";
            advice = "You need to watch your diet, you're getting close to be overweight.";
        }else if (25 <= bmi && bmi < 27) {
            condition = "Overweight";
            advice = "Okay, that level can be reversed. Don't loose hope. Eat healthy. Do sports.";
        }else if (27 <= bmi && bmi < 30) {
            condition = "Overweight";
            advice = "That is bad for health, you need a healthy diet immediately. Do sports.";
        } else if (30 <= bmi){
            condition = "Obese";
            advice = "You need to see a doctor, this might get serious.";
        }
        textCondition.setText(condition);
        textComment.setText(advice);
    }
}

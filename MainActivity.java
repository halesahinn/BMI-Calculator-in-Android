package com.hale.a150116841hw1;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText weight,height;
    Button submit;
    double weightNumber,heightNumber,bmiNumber;
    String weightString,heightString,bmiString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                weightString = weight.getText().toString();
                heightString = height.getText().toString();

                weightNumber = Double.parseDouble(weightString);
                heightNumber = Double.parseDouble(heightString);

                bmiNumber = weightNumber / (heightNumber*heightNumber);

                Intent intent = new Intent(MainActivity.this,Result.class);
                bmiString = Double.toString(bmiNumber);
                intent.putExtra("_bmi",bmiString);
                startActivity(intent);

            }
        });
    }
}

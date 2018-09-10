package com.mehadihassan.cgpacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.RunnableScheduledFuture;

public class directCgpaCalc extends AppCompatActivity {

    private EditText cgpaEdit;
    private EditText totalCreditEdit;
    private EditText gradeEdit;
    private EditText creditEdit;

    private Button add;
    private Button calc;
    private Button reset;

    private TextView cgpaText;
    private TextView courseText;

    private int i = 0;
    private double sumGrade = 0;
    private double sumCredit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_cgpa_calc);

        cgpaEdit = findViewById(R.id.cgpaEditTextId);
        totalCreditEdit = findViewById(R.id.totalCreditEarnedEditTextId);
        gradeEdit = findViewById(R.id.gradeEditTextId);
        creditEdit = findViewById(R.id.creditEcitTextId);

        add = findViewById(R.id.addButtonId);
        calc = findViewById(R.id.calculateButtonId);
        reset =findViewById(R.id.resetButtonId);

        cgpaText = findViewById(R.id.cgpaTextViewId);
        courseText = findViewById(R.id.addedCourseTextViewId);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(Double.parseDouble(creditEdit.getText().toString())<=4
                            && Double.parseDouble(creditEdit.getText().toString())>=1) {
                        if (Double.parseDouble(gradeEdit.getText().toString()) <= 4
                                && Double.parseDouble(gradeEdit.getText().toString()) >= 1) {

                            sumGrade = sumGrade + Double.parseDouble(gradeEdit.getText().toString()) * Double.parseDouble(creditEdit.getText().toString());
                            sumCredit = sumCredit + Double.parseDouble(creditEdit.getText().toString());

                            i++;

//                            courseText.setText(courseText.getText() + "\n" + "Course " + i + "\nGrade: " + gradeEdit.getText().toString()
//
//                                    + "Credit: " + creditEdit.getText().toString());

                            Toast.makeText(directCgpaCalc.this, "Added", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(directCgpaCalc.this, "Enter Correct Values", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else{
                        Toast.makeText(directCgpaCalc.this, "Enter Correct Values", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e){
                    Toast.makeText(directCgpaCalc.this, "Enter Values", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

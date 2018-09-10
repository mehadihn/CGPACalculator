package com.mehadihassan.cgpacalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button cgpaCalc;
    private Button directCgpaCalc;
    private AlertDialog.Builder aleartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cgpaCalc = findViewById(R.id.cgpaId);
        directCgpaCalc = findViewById(R.id.directcgpaId);

        cgpaCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CGPACalc.class);
                startActivity(intent);
            }
        });

        directCgpaCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , directCgpaCalc.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        aleartDialog = new AlertDialog.Builder(MainActivity.this);
        aleartDialog.setTitle("Do you want to exit?");
        aleartDialog.setCancelable(false);
        aleartDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        aleartDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        aleartDialog.show();
    }
}

package com.example.helloworld.CrudMk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class MatkulMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_main);
        Button btnGet = (Button)findViewById(R.id.btnGetDosen);
        Button btnAdd = (Button)findViewById(R.id.btnAddDosen);
        Button btnEdt = (Button)findViewById(R.id.btnUpDosen);
        Button btnDel = (Button)findViewById(R.id.btnDelDosen);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatkulMainActivity.this, MatkulGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatkulMainActivity.this, MatkulAddActivity.class);
                startActivity(intent);
            }
        });

        btnEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatkulMainActivity.this, MatkulUpdateActivity.class);
                startActivity(intent);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatkulMainActivity.this, MatkulDeleteActivity.class);
                startActivity(intent);
            }
        });
    }
}
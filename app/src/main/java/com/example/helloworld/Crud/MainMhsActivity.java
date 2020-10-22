package com.example.helloworld.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class MainMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        //button
        Button btnGetMhs = (Button) findViewById(R.id.buttonGetMhs);
        Button btnAddMhs = (Button) findViewById(R.id.buttonAddMhs);
        Button btnDelMhs = (Button) findViewById(R.id.buttonDelMhs);

        //Fungsi
        btnGetMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class
                );
                startActivity(intent);
            }
        });

        btnAddMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class
                );
                startActivity(intent);
            }
        });

        btnDelMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaDeleteActivity.class);
                startActivity(intent);
            }
        });

    }
}
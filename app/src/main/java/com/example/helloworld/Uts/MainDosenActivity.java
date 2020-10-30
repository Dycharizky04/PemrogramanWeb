package com.example.helloworld.Uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.Crud.MahasiswaDeleteActivity;
import com.example.helloworld.Crud.MahasiswaGetAllActivity;
import com.example.helloworld.Crud.MahasiswaUpdateActivity;
import com.example.helloworld.Crud.MainMhsActivity;
import com.example.helloworld.R;

public class MainDosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dosen);


        //Button
        Button buttonGetD= (Button)findViewById(R.id.btnGetDosen);
        Button buttonAddD= (Button)findViewById(R.id.btnAddDosen);
        Button buttonDelD = (Button)findViewById(R.id.btnDelDosen);
        Button buttonUpD = (Button)findViewById(R.id.btnUpDosen);

        //Function
        buttonGetD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, DosenGetAllActivity.class
                );
                startActivity(intent);
            }
        });


        buttonAddD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, DosenAddActivity.class);
                startActivity(intent);
            }
        });

        buttonDelD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, DosenDeleteActivity.class);
                startActivity(intent);
            }
        });

        buttonUpD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDosenActivity.this, DosenUpdateActivity.class);
                startActivity(intent);
            }
        });






    }
}
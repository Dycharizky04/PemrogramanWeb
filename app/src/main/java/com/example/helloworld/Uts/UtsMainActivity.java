package com.example.helloworld.Uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.helloworld.Crud.MainMhsActivity;
import com.example.helloworld.CrudMk.MatkulMainActivity;
import com.example.helloworld.R;

public class UtsMainActivity extends AppCompatActivity {

    String isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uts_main);

        TextView tampil = (TextView)findViewById(R.id.textViewWelcome);
        Button btnOut = (Button) findViewById(R.id.btnLogOut);
        ImageButton btnDsn = (ImageButton) findViewById(R.id.imageButtonDsn);
        ImageButton btnMhs = (ImageButton) findViewById(R.id.imageButtonMhs);
        ImageButton btnMk = (ImageButton) findViewById(R.id.imageButtonMatkul);

        Bundle b = getIntent().getExtras();
        String textHelp = b.getString("help_string");
        tampil.setText(textHelp);

        SharedPreferences pref = UtsMainActivity.this.getSharedPreferences("pref_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtsMainActivity.this, PrefActivity.class);
                startActivity(intent);
                isLogin = pref.getString("isLogin", "0");
                if(isLogin.equals("0")){
                    editor.putString("isLogin", "1");
                }else{
                    editor.putString("isLogin","0");
                }
                editor.commit();
                          }
        });

        btnMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtsMainActivity.this, MainMhsActivity.class);
                startActivity(intent);
            }
        });

        btnDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtsMainActivity.this, MainDosenActivity.class);
                startActivity(intent);
            }
        });

        btnMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtsMainActivity.this, MatkulMainActivity.class);
                startActivity(intent);
            }
        });
    }
}


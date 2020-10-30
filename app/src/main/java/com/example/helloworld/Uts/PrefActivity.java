package com.example.helloworld.Uts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.Crud.MainMhsActivity;
import com.example.helloworld.R;

import java.util.List;

public class PrefActivity extends AppCompatActivity {

    String isLogin;
    ProgressDialog pd;
    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        Button buttonlogin = (Button)findViewById(R.id.buttonLogin);

        SharedPreferences pref = PrefActivity.this.getSharedPreferences("pref_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        isLogin = pref.getString("isLogin", "0");
        if(isLogin.equals("1")){
            buttonlogin.setText("Logout");
        }else{
            buttonlogin.setText("Login");
        }

        final EditText un = (EditText)findViewById(R.id.editTextUserName);
        final EditText pass = (EditText)findViewById(R.id.editTextPassword);
        pd = new ProgressDialog(PrefActivity.this);

        buttonlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pd.setTitle("Loading");
                pd.show();

                Intent intent = new Intent(PrefActivity.this, UtsMainActivity.class);
                Bundle b = new Bundle();
                b.putString("help_string", un.getText().toString());
                intent.putExtras(b);

                if(un.getText().toString().length() == 0){
                    un.setError("Username");
                }else if(pass.getText().toString().length()==0){
                    pass.setError("Password");
                }else{
                    Toast.makeText(getApplicationContext(),"Berhasil Login", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }


                isLogin = pref.getString("isLogin", "0");
                if(isLogin.equals("0")){
                    editor.putString("isLogin", "1");
                    buttonlogin.setText("Logout");
                }else{
                    editor.putString("isLogin","0");
                    buttonlogin.setText("Login");
                }

                editor.commit();
            }
        });
    }
}
package com.example.helloworld;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld.Pertemuan2.CardActvity;
import com.example.helloworld.Pertemuan2.ListActivity;
import com.example.helloworld.Pertemuan2.RecyclerActivity;
import com.example.helloworld.Pertemuan4.DebuggingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        final TextView txtView = (TextView)findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button)findViewById(R.id.button1);
        final EditText myEditText =  (EditText)findViewById(R.id.editText1);
        Button btnHelp = (Button)findViewById(R.id.btnHelp);

        //Pertemuan2
        Button btnList = (Button) findViewById(R.id.buttonListView);
        Button btnRecycler = (Button) findViewById(R.id.buttonRecylerView);
        Button btnCard = (Button) findViewById(R.id.buttonCardView);
        Button btnPertemuan = (Button) findViewById(R.id.btnPertemuan);

        //Action
        txtView.setText(R.string.text_hello_world);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Log.d("COBA KLIKKKK",myEditText.getText().toString());
                txtView.setText(myEditText.getText().toString());
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class
                );
                Bundle b = new Bundle();
                b.putString("help_string",myEditText.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardActvity.class
                );
                startActivity(intent);
            }
        });



        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class
                );
                startActivity(intent);
            }
        });

        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });


        btnPertemuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DebuggingActivity.class);
                startActivity(intent);
            }
        });

    }
    public void Tracker(View view){
        Intent intent = new Intent(MainActivity.this,TrackerActivity.class);
        startActivity(intent);
    }
}
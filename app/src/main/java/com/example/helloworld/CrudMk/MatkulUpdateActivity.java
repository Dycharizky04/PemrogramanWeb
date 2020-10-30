package com.example.helloworld.CrudMk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld.Model.DefaultResult;
import com.example.helloworld.Network.GetDataService;
import com.example.helloworld.Network.RetrofitClientInstance;
import com.example.helloworld.R;
import com.example.helloworld.Uts.DosenUpdateActivity;
import com.example.helloworld.Uts.MainDosenActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulUpdateActivity extends AppCompatActivity {

    EditText editTextKodeCari, editTextNama, editTextKode, editTextHari, editTextSesi, editTextSks;
    Button btnUbah;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_update);

        editTextNama = (EditText)findViewById(R.id.editTextNamaBaru);
        editTextKode = (EditText)findViewById(R.id.editTextKodeBaru);
        editTextKodeCari = (EditText)findViewById(R.id.editTextKodeCari);
        editTextHari = (EditText)findViewById(R.id.editTextHariBaru);
        editTextSesi = (EditText)findViewById(R.id.editTextSesiBaru);
        editTextSks = (EditText)findViewById(R.id.editTextSksBaru);
        btnUbah = (Button)findViewById(R.id.buttonUbah);
        pd = new ProgressDialog(MatkulUpdateActivity.this);

        Intent data = getIntent();
        if (data.getExtras() != null) {
            editTextNama.setText(data.getStringExtra("nama"));
            editTextKode.setText(data.getStringExtra("kode"));
            editTextKodeCari.setText(data.getStringExtra("kode_cari"));
            editTextHari.setText(data.getStringExtra("hari"));
            editTextSesi.setText(data.getStringExtra("sesi"));
            editTextSks.setText(data.getStringExtra("sks"));
        }

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Silahkan Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance. getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_matkul(
                        editTextNama.getText().toString(),
                        editTextKode.getText().toString(),
                        editTextKodeCari.getText().toString(),
                        editTextHari.getText().toString(),
                        editTextSesi.getText().toString(),
                        editTextSks.getText().toString(),
                        "72180194"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this,"Data Berhasil di Update",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this,"Gagal di Update",Toast.LENGTH_LONG).show();
                    }
                });

                Intent intent = new Intent(MatkulUpdateActivity.this, MatkulMainActivity.class);
                startActivity(intent);
            }
        });
    }}
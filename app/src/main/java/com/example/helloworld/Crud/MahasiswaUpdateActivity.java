package com.example.helloworld.Crud;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaUpdateActivity extends AppCompatActivity {

    EditText editTextNimCari, editTextNama, editTextNim, editTextAlamat, editTextEmail;
    Button btnUbah;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);

        editTextNama = (EditText)findViewById(R.id.editTextNamaBaru);
        editTextNim = (EditText)findViewById(R.id.editTextKodeBaru);
        editTextNimCari = (EditText)findViewById(R.id.editTextKodeCari);
        editTextAlamat = (EditText)findViewById(R.id.editTextHariBaru);
        editTextEmail = (EditText)findViewById(R.id.editTextSesiBaru);
        btnUbah = (Button)findViewById(R.id.buttonUbah);
        pd = new ProgressDialog(MahasiswaUpdateActivity.this);

        Intent data = getIntent();
        editTextNama.setText(data.getStringExtra("nama"));
        editTextNim.setText(data.getStringExtra("nim"));
        editTextNimCari.setText(data.getStringExtra("nim"));
        editTextAlamat.setText(data.getStringExtra("alamat"));
        editTextEmail.setText(data.getStringExtra("email"));

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Silahkan Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance. getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mhs(
                        editTextNama.getText().toString(),
                        editTextNim.getText().toString(),
                        editTextNimCari.getText().toString(),
                        editTextAlamat.getText().toString(),
                        editTextEmail.getText().toString(),
                        //"Fotonya Diubah",
                        "72180194"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Data Berhasil di Update",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Gagal di Update",Toast.LENGTH_LONG).show();
                    }
                });

                Intent intent = new Intent(MahasiswaUpdateActivity.this,MainMhsActivity.class);
                startActivity(intent);
            }
        });
    }}
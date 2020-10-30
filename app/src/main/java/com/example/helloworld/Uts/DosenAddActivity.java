package com.example.helloworld.Uts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld.Crud.MahasiswaAddActivity;
import com.example.helloworld.Model.DefaultResult;
import com.example.helloworld.Network.GetDataService;
import com.example.helloworld.Network.RetrofitClientInstance;
import com.example.helloworld.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add);

        EditText edNama = (EditText)findViewById(R.id.editTextNamaDosen);
        EditText edNik = (EditText)findViewById(R.id.editTextNikDosen);
        EditText edAlamat = (EditText)findViewById(R.id.editTextAlamatDosen);
        EditText edEmail = (EditText)findViewById(R.id.editTextEmailDosen);
        EditText edGelar = (EditText)findViewById(R.id.editTextGelarDosen);
        Button btnSimpan = (Button)findViewById(R.id.btnSimpanTambah);
        pd = new ProgressDialog(DosenAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dosen(
                        edNama.getText().toString(),
                        edNik.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        edGelar.getText().toString(),
                        "kosongkan",
                        "72180194"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

}
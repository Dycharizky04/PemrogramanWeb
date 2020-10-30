package com.example.helloworld.CrudMk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class MatkulAddActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_add);

        final EditText edNama = (EditText) findViewById(R.id.editTeksNamaMk);
        final EditText edKode = (EditText) findViewById(R.id.editTeksKodeMk);
        final EditText edHari = (EditText) findViewById(R.id.editTeksHariMk);
        final EditText edSesi = (EditText) findViewById(R.id.editTeksSesiMk);
        final EditText edSks = (EditText) findViewById(R.id.editTeksSksMk);
        Button btnSimpan = (Button) findViewById(R.id.btnSave);
        pd = new ProgressDialog(MatkulAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Loading");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_matkul(
                        edNama.getText().toString(),
                        edKode.getText().toString(),
                        edHari.getText().toString(),
                        edSesi.getText().toString(),
                        edSks.getText().toString(),
                        "72180194"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        Toast.makeText(MatkulAddActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
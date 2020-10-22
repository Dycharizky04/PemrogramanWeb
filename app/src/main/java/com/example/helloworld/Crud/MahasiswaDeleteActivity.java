package com.example.helloworld.Crud;

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

public class MahasiswaDeleteActivity extends AppCompatActivity {

        ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_delete);

        EditText edNim = (EditText)findViewById(R.id.editNim);
        Button btnHapus = (Button)findViewById(R.id.btnHapus);
        pd = new ProgressDialog(MahasiswaDeleteActivity.this);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_mhs(
                        edNim.getText().toString(),
                        "72180194"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaDeleteActivity.this, "Data Berhasil Dihapus", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaDeleteActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
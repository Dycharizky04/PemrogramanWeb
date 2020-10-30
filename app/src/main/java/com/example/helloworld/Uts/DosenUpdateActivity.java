package com.example.helloworld.Uts;

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

public class DosenUpdateActivity extends AppCompatActivity {

    EditText editTextNidnCari, editTextNama, editTextNidn, editTextAlamat, editTextEmail, editTextGelar;
    Button btnUbah;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_update);

        editTextNama = (EditText)findViewById(R.id.editTextNamaBaru);
        editTextNidn = (EditText)findViewById(R.id.editTextKodeBaru);
        editTextNidnCari = (EditText)findViewById(R.id.editTextKodeCari);
        editTextAlamat = (EditText)findViewById(R.id.editTextHariBaru);
        editTextEmail = (EditText)findViewById(R.id.editTextSesiBaru);
        editTextGelar = (EditText)findViewById(R.id.editTextSksBaru);
        btnUbah = (Button)findViewById(R.id.buttonUbah);
        pd = new ProgressDialog(DosenUpdateActivity.this);

        Intent data = getIntent();
        if (data.getExtras() != null) {
            editTextNama.setText(data.getStringExtra("nama"));
            editTextNidn.setText(data.getStringExtra("nidn"));
            editTextNidnCari.setText(data.getStringExtra("nidn"));
            editTextAlamat.setText(data.getStringExtra("alamat"));
            editTextEmail.setText(data.getStringExtra("email"));
            editTextGelar.setText(data.getStringExtra("gelar"));
        }

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Silahkan Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance. getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_dosen(
                        editTextNama.getText().toString(),
                        editTextNidn.getText().toString(),
                        editTextNidnCari.getText().toString(),
                        editTextAlamat.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextGelar.getText().toString(),
                        "Fotonya Diubah",
                        "72180194"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Data Berhasil di Update",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Gagal di Update",Toast.LENGTH_LONG).show();
                    }
                });

                Intent intent = new Intent(DosenUpdateActivity.this, MainDosenActivity.class);
                startActivity(intent);
            }
        });
    }}
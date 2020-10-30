package com.example.helloworld.CrudMk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.Adapter.MatkulCRUDRecyclerAdapter;
import com.example.helloworld.Model.Matkul;
import com.example.helloworld.Network.GetDataService;
import com.example.helloworld.Network.RetrofitClientInstance;
import com.example.helloworld.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulGetAllActivity extends AppCompatActivity {


        RecyclerView rvMk;
        MatkulCRUDRecyclerAdapter matkulAdapter;
        ProgressDialog pd;
        List<Matkul> matkulList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_matkul_get_all);

            rvMk = (RecyclerView)findViewById(R.id.rvGetMkAll);
            pd = new ProgressDialog(this);
            pd.setTitle("Loading");
            pd.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<List<Matkul>> call = service.getMatkul("72180194");

            call.enqueue(new Callback<List<Matkul>>() {
                @Override
                public void onResponse(Call<List<Matkul>> call, Response<List<Matkul>> response) {
                    pd.dismiss();
                    matkulList = response.body();
                    matkulAdapter = new MatkulCRUDRecyclerAdapter(matkulList);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulGetAllActivity.this);
                    rvMk.setLayoutManager(layoutManager);
                    rvMk.setAdapter(matkulAdapter);
                }

                @Override
                public void onFailure(Call<List<Matkul>> call, Throwable t) {
                    pd.dismiss();
                    Toast.makeText(MatkulGetAllActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
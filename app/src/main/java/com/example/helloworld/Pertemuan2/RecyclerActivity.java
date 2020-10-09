package com.example.helloworld.Pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Adapter.MahasiswaRecyclerAdapter;
import com.example.helloworld.Model.Mahasiswa;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;
        //data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa( "Dycha", "72180194", "087711736969");
        Mahasiswa m2 = new Mahasiswa( "Dychi", "72180195", "087711736960");
        Mahasiswa m3 = new Mahasiswa( "Dychu", "72180196", "087711736961");
        Mahasiswa m4 = new Mahasiswa( "Dyche", "72180197", "087711736962");
        Mahasiswa m5 = new Mahasiswa( "Dycho", "72180198", "087711736963");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(RecyclerActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);

    }
}
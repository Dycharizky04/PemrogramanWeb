package com.example.helloworld.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Model.Mahasiswa;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaCRUDRecyclerAdapter extends RecyclerView.Adapter<MahasiswaCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Mahasiswa> mahasiswaList;

    public MahasiswaCRUDRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }

    public MahasiswaCRUDRecyclerAdapter(List<Mahasiswa> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa m = mahasiswaList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.tvNim.setText(m.getNim());
        holder.tvAlamat.setText(m.getAlamat());
        holder.tvEmail.setText(m.getEmail());
        //holder.tvNotelp.setText(m.getNotelp());
    }


    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvNotelp, tvAlamat, tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);

            //tvNotelp = itemView.findViewById(R.id.tvNoTelp);

        }
    }
}

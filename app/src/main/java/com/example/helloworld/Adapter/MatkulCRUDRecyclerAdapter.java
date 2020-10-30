package com.example.helloworld.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Model.Matkul;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class MatkulCRUDRecyclerAdapter extends RecyclerView.Adapter<MatkulCRUDRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Matkul> matkulList;

    public MatkulCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matkulList = new ArrayList<>();
    }


    public MatkulCRUDRecyclerAdapter(List<Matkul> matkulList){ this.matkulList = matkulList; }

    public List<Matkul> getMatkulList() {
        return matkulList;
    }

    public void setMatkulList(List<Matkul> matkulList) {
        this.matkulList = matkulList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview2,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Matkul m = matkulList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.tvKode.setText(m.getKode());
        holder.tvHari.setText(m.getHari());
        holder.tvSesi.setText(m.getSesi());
        holder.tvSks.setText(m.getSks());
        //holder.tvNotelp.setText(m.getNotelp());
    }


    @Override
    public int getItemCount() {
        return matkulList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvKode, tvHari, tvSesi, tvSks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvKode = itemView.findViewById(R.id.tvKode);
            tvHari = itemView.findViewById(R.id.tvHari);
            tvSesi = itemView.findViewById(R.id.tvSesi);
            tvSks = itemView.findViewById(R.id.tvSks);


        }
    }
}

package com.example.helloworld.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Model.Dosen;
import com.example.helloworld.Model.Mahasiswa;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class DosenRecyclerAdapter extends RecyclerView.Adapter<DosenRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Mahasiswa> dosenList;

    public DosenRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
    }
    public List<Mahasiswa> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Mahasiswa> mahasiswaList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa m = dosenList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.tvNim.setText(m.getNim());
        holder.tvNotelp.setText(m.getNotelp());
    }


    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvNotelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNotelp = itemView.findViewById(R.id.tvNoTelp);

        }
    }
}

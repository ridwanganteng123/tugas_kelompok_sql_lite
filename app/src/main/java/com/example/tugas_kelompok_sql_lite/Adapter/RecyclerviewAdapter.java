package com.example.tugas_kelompok_sql_lite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas_kelompok_sql_lite.Database.Mahasiswa;
import com.example.tugas_kelompok_sql_lite.R;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MahasiswaHolder> {
    List<Mahasiswa> listMahasiswa;
    Context context;
    UserActionListener listener;
    //di comment biar bisa kekomit
    public interface UserActionListener {
        void onUserAction(Mahasiswa mahasiswa);
    }

    public RecyclerviewAdapter(Context context, List<Mahasiswa> listMahasiswa, UserActionListener listener) {
        this.context = context;
        this.listMahasiswa = listMahasiswa;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.MahasiswaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_row_item, parent, false);
        MahasiswaHolder mahasiswaHolder = new MahasiswaHolder(view);
        return mahasiswaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.MahasiswaHolder holder, int position) {
        final Mahasiswa pelajar = listMahasiswa.get(position);
        holder.txtName.setText(pelajar.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onUserAction(pelajar);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public class MahasiswaHolder extends RecyclerView.ViewHolder {
        TextView txtName;

        public MahasiswaHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}

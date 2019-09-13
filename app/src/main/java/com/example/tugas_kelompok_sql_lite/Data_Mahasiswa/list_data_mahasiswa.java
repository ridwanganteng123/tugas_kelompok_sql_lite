package com.example.tugas_kelompok_sql_lite.Data_Mahasiswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tugas_kelompok_sql_lite.Adapter.RecyclerviewAdapter;
import com.example.tugas_kelompok_sql_lite.Database.DatabaseHelper;
import com.example.tugas_kelompok_sql_lite.Database.Mahasiswa;
import com.example.tugas_kelompok_sql_lite.R;

import java.util.List;

public class list_data_mahasiswa extends AppCompatActivity implements RecyclerviewAdapter.UserActionListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Mahasiswa> listMahasiswaInfo;
    Context context;

    Button btnInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_mahasiswa);

        context = this;

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setup();

        btnInput = findViewById(R.id.btnInput);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, input_data.class);
                startActivity(intent);
            }
        });
    }

    public void setup() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        listMahasiswaInfo = databaseHelper.selectUserData();
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this, listMahasiswaInfo, this);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUserAction( final Mahasiswa mahasiswa) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pilihan Data ")
                .setPositiveButton("Lihat Detail Data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent detailData = new Intent(context, Detail_data.class);
                        detailData.putExtra("DETAIL_INTENT", mahasiswa);
                        context.startActivity(detailData);
                    }
                })
                .setNegativeButton("Update Detail Data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent updateData = new Intent(context, update_data.class);
                        updateData.putExtra("UPDATE_INTENT", mahasiswa);
                        updateData.putExtra("UPDATE_ACTION", "Update");
                        context.startActivity(updateData);
                    }
                });//Masukin delete data dibawah sini wan  nanti si ";' nya hapus aja
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

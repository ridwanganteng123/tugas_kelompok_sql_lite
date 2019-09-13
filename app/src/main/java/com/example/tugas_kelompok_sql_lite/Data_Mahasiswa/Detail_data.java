package com.example.tugas_kelompok_sql_lite.Data_Mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.tugas_kelompok_sql_lite.Database.Mahasiswa;
import com.example.tugas_kelompok_sql_lite.R;

public class Detail_data extends AppCompatActivity {
    EditText edtNumber,edtName,edtDate,edtGender, edtLocation;

    //di comment biar bisa kekomit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        edtNumber = findViewById(R.id.txt_nomer);
        edtName = findViewById(R.id.txt_nama);
        edtDate = findViewById(R.id.txt_tgl_lahir);
        edtGender = findViewById(R.id.txt_jenkel);
        edtLocation = findViewById(R.id.txt_lokasi);
        disableThis(edtNumber);
        disableThis(edtName);
        disableThis(edtDate);
        disableThis(edtDate);
        disableThis(edtGender);
        disableThis(edtLocation);

        Mahasiswa mahasiswa = getIntent().getParcelableExtra("DETAIL_INTENT");
        edtNumber.setText(mahasiswa.getNumber());
        edtName.setText(mahasiswa.getName());
        edtDate.setText(mahasiswa.getDate());
        edtGender.setText(mahasiswa.getGender());
        edtLocation.setText(mahasiswa.getLocation());
    }

    public void disableThis(EditText edt) {
        edt.setFocusable(false);
    }
}

package com.example.tugas_kelompok_sql_lite.Data_Mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tugas_kelompok_sql_lite.Database.DatabaseHelper;
import com.example.tugas_kelompok_sql_lite.Database.Mahasiswa;
import com.example.tugas_kelompok_sql_lite.R;

public class input_data extends AppCompatActivity {

    EditText edtNumber,edtName,edtDate,edtGender, edtLocation;
    Button btnInput;
    Context context;
    String aksi = "Simpan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        context = this;

        aksi = getIntent().getStringExtra("UPDATE_ACTION");

        edtNumber = findViewById(R.id.edtNumber);
        edtName = findViewById(R.id.edtName);
        edtDate = findViewById(R.id.edtDate);
        edtGender = findViewById(R.id.edtGender);
        edtLocation = findViewById(R.id.edtLocation);

        btnInput = findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(context);
                Mahasiswa mahasiswa = new Mahasiswa();
                String btnStatus = btnInput.getText().toString();
                mahasiswa.setNumber(edtNumber.getText().toString());
                mahasiswa.setName(edtName.getText().toString());
                mahasiswa.setDate(edtDate.getText().toString());
                mahasiswa.setGender(edtGender.getText().toString());
                mahasiswa.setLocation(edtLocation.getText().toString());
                databaseHelper.insert(mahasiswa);
                Intent intent = new Intent(context, list_data_mahasiswa.class);
                context.startActivity(intent);
            }
        });
    }
}

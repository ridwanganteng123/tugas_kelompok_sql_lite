package com.example.tugas_kelompok_sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    Button btn_lihatdata;
    Button btn_inputdata;
    Button btn_informasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button button = (Button) findViewById(R.id.btn_lihatdata);
        Button button2 = (Button) findViewById(R.id.btn_inputdata);
        Button button3 = (Button) findViewById(R.id.btn_informasi);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_lihatdata:
                startActivity(new Intent(getApplicationContext(), list_data_mahasiswa.class));
                break;
            case R.id.btn_inputdata:
                startActivity(new Intent(getApplicationContext(), input_data.class));
                break;
            case R.id.btn_informasi:
                startActivity(new Intent(getApplicationContext(), Detail_data.class));
                break;
        }
    }
}
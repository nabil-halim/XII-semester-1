package com.itbrain.intentactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Barang extends AppCompatActivity {

    private TextView tvBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);
        initView();
        ambilData();
    }

    private void initView() {
        tvBarang = (TextView) findViewById(R.id.tvBarang);
    }

    public void ambilData(){
        String ambil = getIntent().getStringExtra("ISI");
        tvBarang.setText(ambil);
    }
}
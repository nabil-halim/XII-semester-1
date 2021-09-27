package com.itbrain.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnBarang;
    private Button btnPenjualan;
    private Button btnPembelian;
    private EditText etbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void btnBarang(View view) {
        String barang = etbarang.getText().toString();
        Intent intent = new Intent(this, Barang.class);
        intent.putExtra("ISI",barang);
        startActivity(intent);
    }

    private void initView() {
        btnBarang = (Button) findViewById(R.id.btnBarang);
        btnPenjualan = (Button) findViewById(R.id.btnPenjualan);
        btnPembelian = (Button) findViewById(R.id.btnPembelian);
        etbarang = (EditText) findViewById(R.id.etbarang);
    }
}
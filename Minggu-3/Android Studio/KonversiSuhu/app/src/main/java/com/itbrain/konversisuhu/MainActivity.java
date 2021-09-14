package com.itbrain.konversisuhu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView2;
    private TextView textView;
    private EditText etNilai;
    private Spinner spinner;
    private TextView tvHasil;
    private Button btnKonversi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        isiSpinner();
    }

    public void isiSpinner(){
        String isi[] = {"Celcius To Reamur","Celcius TO Fahrenheit","Celcius To Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();
    }

    private void initView() {
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView = (TextView) findViewById(R.id.textView);
        etNilai = (EditText) findViewById(R.id.etNilai);
        spinner = (Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.tvHasil);
        btnKonversi = (Button) findViewById(R.id.btnKonversi);
    }
}
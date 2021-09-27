package com.itbrain.konversisuhu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    }

//    public void isiSpinner(){
//        String isi[] = {"Celcius To Reamur","Celcius TO Fahrenheit","Celcius To Kelvin"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,isi);
//        spinner.setAdapter(adapter);
//    }

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if (etNilai.getText().toString().equals("")){
            Toast.makeText(this, "Nilai Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }else{
            if(pilihan.equals("Celcius to Reamur")){
                cToR();
            }

            if (pilihan.equals("Celcius to Fahrenheit")){
                cToF();
            }

            if (pilihan.equals("Celcius to Kelvin")){
                cToK();
            }

            if (pilihan.equals("Reamur to Celcius")){
                rToC();
            }

            if(pilihan.equals("Reamur to Fahrenheit")){
                rToF();
            }
        }

    }

    private void initView() {
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView = (TextView) findViewById(R.id.textView);
        etNilai = (EditText) findViewById(R.id.etNilai);
        spinner = (Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.tvHasil);
        btnKonversi = (Button) findViewById(R.id.btnKonversi);
    }

    public void cToR(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;
        tvHasil.setText(hasil+"");
    }

    public void cToF(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = ((9.0/5.0) * suhu) + 32;
        tvHasil.setText(hasil+"");
    }

    public void cToK(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu + 273;
        tvHasil.setText(hasil+"");
    }

    public void rToC(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (5.0/4.0) * suhu;
        tvHasil.setText(hasil+"");
    }

    public void rToF(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = ((9.0/4.0) * suhu) + 32;
        tvHasil.setText(hasil+"");
    }
}
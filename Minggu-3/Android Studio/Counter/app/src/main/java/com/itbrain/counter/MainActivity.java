package com.itbrain.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
    }

    public void btnUP(View view) {
        count++;
        tvHasil.setText(count+"");
    }

    public void btnDown(View view) {
        count--;
        tvHasil.setText(count+"");
    }

    private void load() {
        tvHasil = (TextView) findViewById(R.id.tvHasil);
    }
}